package com.miracle.controller;

import com.miracle.bean.User;
import com.miracle.service.UserService;
import com.miracle.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void addUser(@RequestBody User user){
        int result = userService.addUser(user);
        if(result>0){
            logger.info("新增用户成功{}",user.toString());
        }else{
            logger.error("新泽用户失败");
        }

    }

    @RequestMapping(value = "/delUserByUid/{id}",method = RequestMethod.POST)
    public void delUserByUid(@PathVariable("id") int id){
        logger.info("删除用户uid={}",id);
        User user = getUserInfoByUid(id);
        if(user!=null){
            userService.delUserByUid(id);
        }else {
            logger.error("用户id:{}不存在",id);
        }
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public User updateUser(@RequestBody User user){
        int id = userService.updateUser(user);
        if(id>=1){
            logger.info("更新用户成功-{}",user.toString());
            return user;
        }else{
            logger.error("更新用户失败");
            return null;
        }
    }
    @RequestMapping(value = "/updateUserPwd",method = RequestMethod.POST)
    public User updateUserPwd(@RequestBody User user){
        int id = userService.updateUserPwd(user);
        if(id>=1){
            logger.info("更新用户密码成功-{}",user.toString());
            return user;
        }else{
            logger.error("更新用户密码失败");
            return null;
        }
    }

    @RequestMapping(value = "/getUserInfoByUid/{uid}",method = RequestMethod.GET)
    public User getUserInfoByUid(@PathVariable("uid") int uid){
        User user = userService.getUserInfoByUid(uid);
        if(user!=null){
            logger.info("根据用户id:{}获取用户信息{}",uid,user.toString());
            return user;
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    public Map getAllUsers(){
        List<User> userList = userService.getAllUsers();
        logger.info("查询所有用户{}",userList);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("size",userList.size());
        map.put("userList",userList);
        return map;
    }

    @RequestMapping(value = "/getUserListByName/{name}",method = RequestMethod.GET)
    public Map getUserListByName(@PathVariable("name") String name){
        List<User> userList = userService.getUserListByName(name);
        logger.info("根据用户名:{},查询所有用户{}",name,userList);
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("size",userList.size());
        map.put("userList",userList);
        return map;
    }
}
