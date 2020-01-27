package org.mybatispagination;


import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

@Component
@Intercepts({@Signature(type= StatementHandler.class, method="prepare", args={Connection.class,Integer.class})})
public class PaginationInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
        BoundSql boundSql = statementHandler.getBoundSql();
        Map<?,?> parameter = (Map<?,?>)boundSql.getParameterObject();
        if(parameter != null && parameter.containsKey(Pagination.paramName)){
            Pagination<?> pagination = (Pagination<?>) parameter.get(Pagination.paramName);
            if(pagination != null){
                // 原始的SQL语句
                String sql = boundSql.getSql();
                // 查询总条数的SQL语句
                Connection connection = (Connection)invocation.getArgs()[0];
                String keyColumn = pagination.getKeyColumn();
                String countSql = "";
                String paginationSql = "";
                if(keyColumn == null){  // 单表或者一对一
                    countSql = "select count(*) from (" + sql + ") t";
                    paginationSql = sql + " limit " + pagination.getStart() + ", " + pagination.getSize();
                }else {     // 一对多
                    countSql = "select count(total) from (select count(*) total from (" + sql.replace(pagination.getLimitTag(), "") + ") t group by t." + keyColumn + ") t1";
                    paginationSql = sql.replace(pagination.getLimitTag(), " limit " + pagination.getStart() + ", " + pagination.getSize());
                }
                PreparedStatement countStatement = connection.prepareStatement(countSql);
                ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
                parameterHandler.setParameters(countStatement);
                ResultSet rs = countStatement.executeQuery();
                if(rs.next()) {
                    pagination.setTotal(rs.getInt(1));
                }
                // 改造后带分页查询的SQL语句
                metaObject.setValue("delegate.boundSql.sql", paginationSql);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) { }
}
