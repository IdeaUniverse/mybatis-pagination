## mybatis pagination plugin
### developed by mybatis interceptor
### supports one to one, one to many, nested query


## mybatis分页插件
### 基于 mybatis 拦截器实现
### 支持单表，一对一，一对多嵌套查询

### example
#### config
    @Configuration
    public class PaginationInterceptorConfig {
    
        @Bean
        public PaginationInterceptor paginationInterceptor(){
            return new PaginationInterceptor();
        }
    }


#### one to one
##### sql
    <select id="queryUsers" parameterType="java.lang.Integer"  resultType="org.mybatispagination.demo.entity.User">
        select
               `user`.id,
               `user`.`name`,
               `user`.status
        from `user`
        where status = #{status, jdbcType=INTEGER}
    </select>
##### use
    /**
     * one to one, 一对一
     * http://localhost:8080/mybatis-pagination/test/query-users?page=1
     */
    @GetMapping("/query-users")
    public Pagination<User> queryUsers(@RequestParam Integer page){
        Pagination<User> pagination = new Pagination<>();
        pagination.setPage(page);
        List<User> users = userDao.queryUsers(1, pagination);
        pagination.setContent(users);
        return pagination;
    }
    
#### one to many
##### sql
    <!--       
        1.when one to many query, set the "${pagination.limitTag}" which will be replace to string like "limit 1, 10"
        2.no need for "parameterType"
        
        1.在一对多查询的sql中，应对主表设置limit, "${pagination.limitTag}"是一个标志位，将会被替换成如"limit 1, 10"的语句
        2.不需要写 parameterType
    -->
    <select id="queryUsersWithOrders" resultMap="resultMap">
        select t.*,
        user_order.id order_id,
        user_order.name order_name,
        user_order.user_id
        from (
            select
                   `user`.id,
                   `user`.`name`
            from `user`
            where status = #{status, jdbcType=INTEGER}
            <if test="pagination != null">
                ${pagination.limitTag}
            </if>
        ) t, user_order
        where t.id = user_order.user_id
    </select>

##### use
    /**
     * one to many, 一对多
     * http://localhost:8080/mybatis-pagination/test/query-users-with-orders?page=1
     */
    @GetMapping("/query-users-with-orders")
    public Pagination<User> queryUsersWithOrders(@RequestParam Integer page){
        Pagination<User> pagination = new Pagination<>();
        pagination.setPage(page);
        pagination.setKeyColumn("id");      // set key column for main table (here is the id column of user table), which is for results to group on
        List<User> users = userDao.queryUsersWithOrders(1, pagination);
        pagination.setContent(users);
        return pagination;
    }

### please see mybatis-pagination-demo for code example
### 代码示例请见 mybatis-pagination-demo 

### licences: MIT