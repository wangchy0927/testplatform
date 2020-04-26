package com.miracle.manage.service;

import com.miracle.manage.bean.Module;
import com.miracle.manage.bean.Result;
import com.miracle.manage.dao.ModuleDao;
import com.miracle.manage.dao.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/26 11:16
 */
@Service
public class ModuleService {
    Logger logger = LoggerFactory.getLogger(ModuleService.class);

    @Autowired
    ModuleDao moduleDao;
    @Autowired
    ProductDao productDao;

    public Result addModule(Module module){
        int pid = module.getProduct().getId();
        String pName = module.getProduct().getProductName();
        String name = module.getName();
        logger.info("给产品={}添加模块{}",pName,name);
       /* List<Module> moduleList = productDao.getModuleListByPId(pid);
        for(Module m : moduleList){
            if(m.getName().equals(name)){
                String msg = "产品"+pName+"存在模块"+name+",添加失败";
                logger.info(msg);
                new Result(-1,msg);
            }
        }*/
        int code = moduleDao.addModule(module);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    public Result delModule(int id){
        int code = moduleDao.delModule(id);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    public Result updateModule(Module module){
        int code = moduleDao.updateModule(module);
        return new Result(code,code>0?"操作成功":"操作失败");
    }

    public Result getModuleListByPId(int id){
        logger.info("根据产品id={}查询模块",id);
        List<Module> moduleList = moduleDao.getModuleListByPId(id);
        return new Result(1,moduleList.size(),moduleList);
    }

    public Result getModuleListByPName(String name){
        logger.info("根据产品name={}查询模块",name);
        List<Module> moduleList = moduleDao.getModuleListByPName(name);
        return new Result(1,moduleList.size(),moduleList);
    }

}
