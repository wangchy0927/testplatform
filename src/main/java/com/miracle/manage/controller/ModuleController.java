package com.miracle.manage.controller;

import com.miracle.manage.bean.Module;
import com.miracle.manage.bean.Result;
import com.miracle.manage.service.ModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/26 11:35
 */
@RestController
@RequestMapping("/module")
public class ModuleController {
    Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    ModuleService moduleService;

    @RequestMapping(value = "/addModule",method = RequestMethod.POST)
    public Result addModule(@RequestBody Module module){
        return moduleService.addModule(module);
    }

    @RequestMapping(value = "/delModule/{id}",method = RequestMethod.POST)
    public Result delModule(@PathVariable("id") int id){
        return moduleService.delModule(id);
    }

    @RequestMapping(value = "/updateModule",method = RequestMethod.POST)
    public Result updateModule(@RequestBody Module module){
        return moduleService.updateModule(module);
    }

    @RequestMapping(value = "/getModuleListByPId/{id}",method = RequestMethod.GET)
    public Result getModuleListByPId(@PathVariable("id") int id){
        return moduleService.getModuleListByPId(id);
    }

    @RequestMapping(value = "/getModuleListByPName/{name}",method = RequestMethod.GET)
    public Result getModuleListByPName(@PathVariable("name") String name){
        return moduleService.getModuleListByPName(name);
    }
}
