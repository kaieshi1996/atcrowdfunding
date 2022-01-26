package com.atguigu.crowd.mvc.handler;


import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.util.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdminHandler {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin/do/login.do")
    public String doLogin(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, HttpSession session){
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);

        session.setAttribute(CrowdConstant.ATTR_NAME_EXCEPTION,admin);

        return "admin-main";
    }


}
