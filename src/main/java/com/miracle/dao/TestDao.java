package com.miracle.dao;

import com.miracle.bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/16 18:35
 */

@Repository
@Mapper
public interface  TestDao {
    Test getTestById(int id);
    List<Test> getAllTest();
    void insertTest(Test test);
    void updateTestById(Test test);
}
