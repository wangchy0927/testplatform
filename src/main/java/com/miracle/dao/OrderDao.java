package com.miracle.dao;

import com.miracle.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/20 10:13
 */
@Repository
@Mapper
public interface OrderDao {
    Order getOrderByOId(int id);
    List<Order> getAllOrders();
    void insertOrder(Order order);
}
