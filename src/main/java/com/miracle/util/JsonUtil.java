package com.miracle.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/22 10:13
 */
public class JsonUtil {

    public static String getJsonByObjList(List list){
        Map<Object,Object> map = new HashMap<Object,Object>();
        map.put("num",list.size());
        map.put("objList",list);
        return JSON.toJSONString(map);
    }

}
