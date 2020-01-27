package org.mybatispagination.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatispagination.demo.entity.UserOrder;

public interface UserOrderDao {

    int save(@Param("order") UserOrder order);

    int clear();
}
