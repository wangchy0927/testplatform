package com.miracle.manage.dao;

import com.miracle.manage.bean.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/17 14:43
 */
@Repository
@Mapper
public interface CustomerDao {
    Customer getOrdersByCId(int id);
    List<Customer> getAllCustomer();
}
