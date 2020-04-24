package com.miracle.service;

import com.miracle.bean.Result;
import com.miracle.bean.User;
import com.miracle.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/22 9:48
 */
@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    public Result addUser(User user){
        String loginName = user.getLoginName();
        Result  result = getAllUsers();
        List<User> userList = result.getObjectList();
        for(User u : userList){
            if(u.getLoginName().equals(loginName)){
                return new Result(-1,"新增用户失败:用户名:"+loginName+"已存在");
            }
        }
        int code = userDao.addUser(user);
        return new Result(code,code==1?"新增用户成功":"新增用户失败");
    }
    public Result delUserByUid(int uid){
        logger.info("删除用户uid={}",uid);
        int code = userDao.delUserByUid(uid);
        return new Result(code,code==1?"删除用户成功":"删除用户失败");
    }
    public Result updateUser(User user){
        logger.info("更新用户loginName={}的信息为{}",user.getLoginName(),user.toString());
        int code = userDao.updateUser(user);
        return new Result(code,code==1?"更新用户信息成功":"更新用户信息失败");
    }
    public Result updateUserPwd(User user){
        logger.info("更新用户{}密码",user.getLoginName());
        int code = userDao.updateUserPwd(user);
        return new Result(code,code==1?"更新用户密码成功":"更新用户密码失败");
    }
    public Result getUserInfoByUid(int uid){
        logger.info("获取用户信息uid{}",uid);
        User user = userDao.getUserInfoByUid(uid);
        return new Result(1,user);
    }
    public Result getAllUsers(){
        List<User> userList = userDao.getAllUsers();
        return new Result(1,userList.size(),userList);
    }
    public Result getUserListByName(String name){
        logger.info("根据用户名查询用户:{}",name);
        List<User> userList = userDao.getUserListByName(name);
        return new Result(1,userList.size(),userList);
    }
    public Result addProductsToUser(User user){
        logger.info("给用户{}添加产品权限",user.getLoginName());
        int code = userDao.addProductsToUser(user);
        return new Result(code,code>0?"操作成功":"操作失败");
    }
}
