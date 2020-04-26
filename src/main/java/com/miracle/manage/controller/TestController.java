package com.miracle.manage.controller;

import com.miracle.manage.bean.*;
import com.miracle.manage.service.CustomerService;
import com.miracle.manage.service.OrderService;
import com.miracle.manage.service.TestService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public Test getTest(){
        Test test = new Test();
        test.setName("Miracle");
        test.setId(1);
        test.setAge(22);
        return test;
    }

    @RequestMapping(value = "/loginError",method = RequestMethod.GET)
    public String loginError(){
        return "权限验证失败的页面";
    }
    @RequestMapping(value = "/loginSuc",method = RequestMethod.GET)
    public String loginSuc(){
        return "恭喜登陆成功";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "请登录";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }
    }

    @RequestMapping(value = "/test/getAllTest",method = RequestMethod.GET)
    public List<Test> getAllTest(){
        return testService.getAllTest();
    }

    @RequestMapping(value = "/test/getTestById",method = RequestMethod.GET)
    public Test getTestById(int id){
        return testService.getTestById(id);
    }

    @RequestMapping(value = "/test/insertTest",method = RequestMethod.POST)
    public void insertTest(@RequestBody Test test){
        testService.insertTest(test);
    }

    @RequestMapping(value = "/test/updateTest",method = RequestMethod.POST)
    public void updateTestById(@RequestBody Test test){
        testService.updateTestById(test);
    }

    @RequestMapping(value = "/test/addTest",method = RequestMethod.POST)
    public void addTest(@RequestBody Test test){
        logger.info(test.getName()+"-"+test.toString());
    }

    @RequestMapping(value = "/order/getOrdersByCId/{id}",method = RequestMethod.GET)
    public Customer getOrdersByCId(@PathVariable("id") int id){
        return customerService.getOrdersByCId(id);
    }

    @RequestMapping(value = "/order/getAllCustomer",method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/order/getOrderByOId/{id}",method = RequestMethod.GET)
    public Order getOrderByOId(@PathVariable("id") int id){
        return orderService.getOrderByOId(id);
    }

    @RequestMapping(value = "/order/getAllOrders",method = RequestMethod.GET)
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/order/insertOrder",method = RequestMethod.POST)
    public void insertOrder(@RequestBody Order order){
        orderService.insertOrder(order);
    }

    @RequestMapping(value = "/userProducts",method = RequestMethod.GET)
    public User test(){
        User user = new User();
        user.setId(1);
        user.setLoginName("miracle");
        Product p = new Product();
        p.setId(1);
        p.setProductName("11");
        Product p2 = new Product();
        p2.setId(2);
        p2.setProductName("22");
        List<Product> productList = new ArrayList<Product>();
        productList.add(p);productList.add(p2);
        user.setProductList(productList);
        return user;
    }
}
