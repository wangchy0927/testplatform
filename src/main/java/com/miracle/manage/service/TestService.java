package com.miracle.manage.service;

import com.miracle.manage.bean.Test;
import com.miracle.manage.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/16 19:33
 */

@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public Test getTestById(int id){
        return testDao.getTestById(id);
    }

    public List<Test> getAllTest() {
        return testDao.getAllTest();
    }

    public void insertTest(Test test) {
        testDao.insertTest(test);
    }

    public void updateTestById(Test test) {
        testDao.updateTestById(test);
    }
}
