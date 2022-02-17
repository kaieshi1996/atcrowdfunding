package com.atguigu.crowd.mvc.handler;


import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.util.CrowdConstant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);

        return "redirect:/admin/to/main.do";
    }

    @RequestMapping("/admin/do/logout.do")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/to/login.do";
    }

    @RequestMapping("/admin/get/page.do")
    public String getPageInfo(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                              ModelMap modelMap){
        // 调用service方法获取PageInfo对象
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);
        // 将PageInfo对象存入模型
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        System.out.println(modelMap.getAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO));
        return "admin-page";

    }

    @RequestMapping("/admin//remove/{adminId}/{pageNum}/{keyword}.do")
    public String remove(@PathVariable("adminId") Integer adminId,
                         @PathVariable("pageNum") Integer pageNum,
                         @PathVariable("keyword") String keyword) {
        adminService.remove(adminId);

        return "redirect:/admin/get/page.do?pageNum="+pageNum+"&keyword="+keyword;

    }

    @RequestMapping("/admin/save.do")
    public String saveAdmin(Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.do?pageNum="+Integer.MAX_VALUE;
    }

    @RequestMapping("/admin/to/edit.do")
    public String toEdit(@RequestParam("adminId") Integer adminId,ModelMap modelMap){
        Admin admin = adminService.getAdminById(adminId);
        modelMap.addAttribute("admin",admin);
        return "admin-edit";
    }

    @RequestMapping(value = "/admin/update.do")
    public String update(Admin admin,
                         @RequestParam(value = "keyword",defaultValue = "") String keyword,
                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        System.out.println(admin);
        adminService.update(admin);
        return "redirect:/admin/get/page.do?pageNum="+pageNum+"&keyword="+keyword;
    }





}
