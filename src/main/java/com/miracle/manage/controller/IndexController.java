package com.miracle.manage.controller;

import com.miracle.manage.bean.Result;
import com.miracle.manage.bean.User;
import com.miracle.manage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：
 *
 * @Author: Miracle
 * @Date: 2020/4/26 17:18
 */
@Controller
public class IndexController {

    Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(){
        return "redirect:/web/login.html";
    }

    @RequestMapping(value = "/con",method = RequestMethod.GET)
    public String con(){
        return "redirect:/test/loginError";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        logger.info("用户名={},密码={}",loginName,password);
        Result result = userService.getUserByLoginName(loginName);
        User user = (User) result.getObject();
        String msg = "";
        int code = -1;
        if(user==null){
            msg = "用户="+loginName+"不存在";
        }else if(user.getPassword().equals(password)){
            msg = "用户="+user.getLoginName()+"登陆成功，角色是="+user.getRole();
            code = 1;
        }else {
            msg = "用户名和密码不匹配";
        }
        logger.info(msg);
        if(code==-1){
            return "redirect:/test/loginError";
        } else{
            return "redirect:/user/getAllUsers";
        }
    }
}
