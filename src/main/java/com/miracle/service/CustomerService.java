package com.miracle.service;

import com.miracle.bean.Customer;
import com.miracle.bean.Order;
import com.miracle.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/17 14:46
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer getOrdersByCId(int id){
        return customerDao.getOrdersByCId(id);
    }
    public List<Customer> getAllCustomer(){
        return  customerDao.getAllCustomer();
    }
}
