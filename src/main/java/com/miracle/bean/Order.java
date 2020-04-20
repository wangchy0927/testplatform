package com.miracle.bean;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/17 14:38
 */
public class Order {
    private int id;
    private Customer customer;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
