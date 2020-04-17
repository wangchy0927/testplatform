package com.miracle.controller;

import com.miracle.bean.Customer;
import com.miracle.bean.Order;
import com.miracle.bean.Test;
import com.miracle.service.CustomerService;
import com.miracle.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/16 17:09
 */
@RestController
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    TestService testService;
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public Test getTest(){
        Test test = new Test();
        test.setName("Miracle");
        test.setId(1);
        test.setAge(22);
        return test;
    }

    @RequestMapping(value = "/getAllTest",method = RequestMethod.GET)
    public List<Test> getAllTest(){
        return testService.getAllTest();
    }

    @RequestMapping(value = "/getTestById",method = RequestMethod.GET)
    public Test getTestById(int id){
        return testService.getTestById(id);
    }

    @RequestMapping(value = "/insertTest",method = RequestMethod.POST)
    public void insertTest(@RequestBody Test test){
        testService.insertTest(test);
    }

    @RequestMapping(value = "/updateTest",method = RequestMethod.POST)
    public void updateTestById(@RequestBody Test test){
        testService.updateTestById(test);
    }

    @RequestMapping(value = "/addTest",method = RequestMethod.POST)
    public void addTest(@RequestBody Test test){
        logger.info(test.getName()+"-"+test.toString());
    }

    @RequestMapping(value = "/getOrdersByCId/{id}",method = RequestMethod.GET)
    public Customer getOrdersByCId(@PathVariable("id") int id){
        return customerService.getOrdersByCId(id);
    }

    @RequestMapping(value = "/getAllCustomer",method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }
}
