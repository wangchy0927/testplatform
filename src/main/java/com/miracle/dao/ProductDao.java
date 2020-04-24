package com.miracle.dao;

import com.miracle.bean.Product;
import com.miracle.bean.User;
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
