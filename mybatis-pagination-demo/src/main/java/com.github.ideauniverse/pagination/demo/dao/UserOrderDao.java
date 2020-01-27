package com.github.ideauniverse.pagination.demo.dao;

import org.apache.ibatis.annotations.Param;
import com.github.ideauniverse.pagination.demo.entity.UserOrder;

public interface UserOrderDao {

    int save(@Param("order") UserOrder order);

    int clear();
}
