package com.github.ideauniverse.pagination.demo.dao;

import com.github.ideauniverse.pagination.Pagination;
import org.apache.ibatis.annotations.Param;
import com.github.ideauniverse.pagination.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> queryUsers(@Param("status") Integer status,
                          @Param("pagination") Pagination<User> pagination);

    List<User> queryUsersWithOrders(@Param("status") Integer status,
                                    @Param("pagination") Pagination<User> pagination);

    int save(@Param("user") User user);

    int clear();
}
