package com.miracle.manage.service;

import com.miracle.manage.bean.Result;
import com.miracle.manage.bean.User;
import com.miracle.manage.dao.UserDao;
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
        logger.info("新增用户={}",loginName);
        Result  result = getUserListByName(loginName);
        List<User> userList = result.getObjectList();
        for(User u : userList){
            if(u.getLoginName().equals(loginName)){
                String msg = "新增用户失败:用户名:"+loginName+"已存在";
                logger.info(msg);
                return new Result(-1,msg);
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
        logger.info("查询所有用户");
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

    public Result getUserProducts(int id){
        logger.info("获取用户id={}名下的产品",id);
        User user = userDao.getUserProducts(id);
        return new Result(1,user);
    }
}
