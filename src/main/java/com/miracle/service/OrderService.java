package com.miracle.service;

import com.miracle.bean.Order;
import com.miracle.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/20 10:15
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order getOrderByOId(int id){
       return orderDao.getOrderByOId(id);
    }

    public List<Order> getAllOrders(){
        return orderDao.getAllOrders();
    }

    public void insertOrder(Order order){
        orderDao.insertOrder(order);
    }
}
