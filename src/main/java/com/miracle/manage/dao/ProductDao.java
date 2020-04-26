package com.miracle.manage.dao;

import com.miracle.manage.bean.Module;
import com.miracle.manage.bean.Product;
import com.miracle.manage.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/23 17:50
 */
@Repository
@Mapper
public interface ProductDao {
    int addProduct(Product product);
    int delProduct(int id);
    int updateProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProduct();
    List<String> getVersionsByPName(String name);
    List<User> getUsersByPName(String name);
    List<Product> getProductsByName(String name);
}
