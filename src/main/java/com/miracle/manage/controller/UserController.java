package com.miracle.manage.controller;

import com.miracle.manage.bean.Result;
import com.miracle.manage.bean.User;
import com.miracle.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/22 9:54
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Result addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/delUserByUid/{id}",method = RequestMethod.POST)
    public Result delUserByUid(@PathVariable("id") int id){
        return userService.delUserByUid(id);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user){
       return userService.updateUser(user);
    }

    @RequestMapping(value = "/updateUserPwd",method = RequestMethod.POST)
    public Result updateUserPwd(@RequestBody User user){
        return userService.updateUserPwd(user);
    }

    @RequestMapping(value = "/getUserInfoByUid/{uid}",method = RequestMethod.GET)
    public Result getUserInfoByUid(@PathVariable("uid") int uid){
        return userService.getUserInfoByUid(uid);
    }

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    public Result getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/getUserListByName/{name}",method = RequestMethod.GET)
    public Result getUserListByName(@PathVariable("name") String name){
        return userService.getUserListByName(name);
    }

    @RequestMapping(value = "/addProductsToUser",method = RequestMethod.POST)
    public Result addProductsToUser(@RequestBody User user){
        return userService.addProductsToUser(user);
    }

    @RequestMapping(value = "/getUserProducts/{id}",method = RequestMethod.GET)
    public Result getUserProducts(@PathVariable("id") int id){
        return userService.getUserProducts(id);
    }

    @RequestMapping(value = "/getUserByLoginName/{loginName}",method = RequestMethod.GET)
    public Result getUserByLoginName(@PathVariable("loginName") String loginName){
        return userService.getUserByLoginName(loginName);
    }
}
