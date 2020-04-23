package com.miracle.service;

import com.miracle.bean.User;
import com.miracle.dao.UserDao;
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

    @Autowired
    private UserDao userDao;

    public int addUser(User user){
        int result = userDao.addUser(user);
        return result;
    }
    public int delUserByUid(int uid){
        int result = userDao.delUserByUid(uid);
        return result;
    }
    public int updateUser(User user){
        int result = userDao.updateUser(user);
        return result;
    }
    public int updateUserPwd(User user){
        int result = userDao.updateUserPwd(user);
        return result;
    }
    public User getUserInfoByUid(int uid){
        User user = userDao.getUserInfoByUid(uid);
        return user;
    }
    public List<User> getAllUsers(){
        List<User> userList = userDao.getAllUsers();
        return userList;
    }
    public List<User> getUserListByName(String name){
        List<User> userList = userDao.getUserListByName(name);
        return userList;
    }
}
