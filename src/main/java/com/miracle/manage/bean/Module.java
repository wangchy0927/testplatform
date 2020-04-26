package com.miracle.manage.bean;

/**
 * 功能描述：产品下的功能模块
 *
 * @Author: Miracle
 * @Date: 2020/4/26 10:45
 */
public class Module {
    private int id;
    private String name;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
