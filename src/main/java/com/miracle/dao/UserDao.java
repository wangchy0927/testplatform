package com.miracle.dao;

import com.miracle.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/21 20:51
 */
@Repository
@Mapper
public interface UserDao {
    int addUser(User user);
    int delUserByUid(int id);
    int updateUser(User user);
    User getUserInfoByUid(int uid);
    List<User> getAllUsers();
    List<User> getUserListByName(String name);
    int updateUserPwd(User user);
    int addProductsToUser(User user);
    User getUserProducts(int id);
}
