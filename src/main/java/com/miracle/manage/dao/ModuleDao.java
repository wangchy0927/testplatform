package com.miracle.manage.dao;

import com.miracle.manage.bean.Module;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/26 11:06
 */
@Repository
@Mapper
public interface ModuleDao {
    int addModule(Module module);
    int delModule(int id);
    int updateModule(Module module);
    List<Module> getModuleListByPId(int id);
    List<Module> getModuleListByPName(String name);
}
