package com.miracle.bean;

import java.util.List;

/**
 * 功能描述：接口返回值
 *
 * @Author: Miracle
 * @Date: 2020/4/23 18:04
 */
public class Result {
    private int code;
    private String msg;
    private Object object;
    private int size;
    private List objectList;

    public Result(int code, Object object) {
        this.code = code;
        this.object = object;
    }

    public Result(int code, int size, List objectList) {
        this.code = code;
        this.size = size;
        this.objectList = objectList;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List getObjectList() {
        return objectList;
    }

    public void setObjectList(List objectList) {
        this.objectList = objectList;
    }
}
