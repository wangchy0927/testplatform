package com.miracle.controller;

import com.miracle.bean.Product;
import com.miracle.bean.Result;
import com.miracle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/23 20:12
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Result addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @RequestMapping(value = "/getAllProduct",method = RequestMethod.GET)
    public Result getAllProduct(){
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/delProduct/{id}",method = RequestMethod.POST)
    public Result delProduct(@PathVariable("id") int id){
        return productService.delProduct(id);
    }

    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    public Result updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "/getProductById/{id}",method = RequestMethod.GET)
    public Result getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/getVersionsByPName/{name}",method = RequestMethod.GET)
    public Result getVersionsByPName(@PathVariable("name") String name){
        return productService.getVersionsByPName(name);
    }

    @RequestMapping(value = "/getUsersByPName/{name}",method = RequestMethod.GET)
    public Result getUsersByPName(@PathVariable("name") String name){
        return productService.getUsersByPName(name);
    }

    @RequestMapping(value = "/addVersion",method = RequestMethod.POST)
    public Result addVersion(@RequestBody Product product){
        return productService.addVersion(product);
    }
}
