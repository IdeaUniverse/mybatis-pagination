package org.mybatispagination.demo.dao;

import org.mybatispagination.Pagination;
import org.apache.ibatis.annotations.Param;
import org.mybatispagination.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> queryUsers(@Param("status") Integer status,
                          @Param("pagination") Pagination<User> pagination);

    List<User> queryUsersWithOrders(@Param("status") Integer status,
                                    @Param("pagination") Pagination<User> pagination);

    int save(@Param("user") User user);

    int clear();
}
