package com.github.ideauniverse.pagination.demo.controller;

import com.github.ideauniverse.pagination.Pagination;
import com.github.ideauniverse.pagination.demo.dao.UserDao;
import com.github.ideauniverse.pagination.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserDao userDao;

    /**
     * one to one, 一对一
     * http://localhost:8080/test/query-users?page=1
     */
    @GetMapping("/query-users")
    public Pagination<User> queryUsers(@RequestParam Integer page){
        Pagination<User> pagination = new Pagination<>();
        pagination.setPage(page);
        List<User> users = userDao.queryUsers(1, pagination);
        pagination.setContent(users);
        return pagination;
    }

    /**
     * one to many, 一对多
     * http://localhost:8080/test/query-users-with-orders?page=1
     */
    @GetMapping("/query-users-with-orders")
    public Pagination<User> queryUsersWithOrders(@RequestParam Integer page){
        Pagination<User> pagination = new Pagination<>();
        pagination.setPage(page);
        // set key column for main table (here is the id column of user table), which is for results to group on
        pagination.setKeyColumn("id");
        List<User> users = userDao.queryUsersWithOrders(1, pagination);
        pagination.setContent(users);
        return pagination;
    }

}
