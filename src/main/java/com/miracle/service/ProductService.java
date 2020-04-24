package com.miracle.service;

import com.miracle.bean.Product;
import com.miracle.bean.Result;
import com.miracle.bean.User;
import com.miracle.dao.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/23 17:55
 */
@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(Product.class);
    @Autowired
    ProductDao productDao;

    public Result addProduct(Product product){
        String name = product.getProductName();
        logger.info("添加产品={}",name);
        if(exitProduct(name)){
            return new Result(-1,"存在名字"+name+"的产品，操作失败");
        }
        int code = productDao.addProduct(product);
        return new Result(code,code>0?"操作成功":"操作失败");
    }
    public Result delProduct(int id){
        logger.info("删除产品id={}",id);
        int code = productDao.delProduct(id);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    public Result updateProduct(Product product){
        String name = product.getProductName();
        logger.info("更新产品name={}",name);
        if(exitProduct(name)){
            return new Result(-1,"存在名字"+name+"的产品，操作失败");
        }
        int code = productDao.updateProduct(product);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    public Result getProductById(int id){
        logger.info("根据产品id={}查询",id);
        Product product = productDao.getProductById(id);
        return new Result(1,product);
    }

    public Result getAllProduct(){
        logger.info("查询所有产品");
        List<Product> productList = productDao.getAllProduct();
        return new Result(1,productList.size(),productList);
    }

    public Result getVersionsByPName(String name){
        logger.info("根据产品名字[{}]查询版本号",name);
        List<String> versionList = productDao.getVersionsByPName(name);
        return new Result(1,versionList.size(),versionList);
    }

    public Result getUsersByPName(String name){
        logger.info("根据产品name={}查询所属用户",name);
        List<User> userList = productDao.getUsersByPName(name);
        return new Result(1,userList.size(),userList);
    }

    public Result getProductsByName(String name){
        logger.info("根据产品名字[{}]查询",name);
        List<Product> productList = productDao.getProductsByName(name);
        return new Result(1,productList.size(),productList);
    }

    public Result addVersion(Product product){
        String name = product.getProductName();
        String version = product.getVersion();
        logger.info("项目{}添加版本{}",name,version);
        //判断是否存在相同的版本号
        Result result = getVersionsByPName(name);
        if(result.getObjectList().contains(version)){
            return new Result(-1,"操作失败，产品="+name+"存在版本="+version);
        }
        int code = productDao.addProduct(product);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    /**
     * 查询产品是否重名
     * @param name 产品名字
     * */
    private boolean exitProduct(String name){
        Result result = getProductsByName(name);
        List<Product> productList = result.getObjectList();
        boolean flag = false;
        for(Product p : productList){
            if(p.getProductName().equals(name)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
