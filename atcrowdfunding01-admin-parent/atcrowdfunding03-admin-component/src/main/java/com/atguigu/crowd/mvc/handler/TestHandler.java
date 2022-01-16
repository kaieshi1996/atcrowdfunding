package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.AdminService;

import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestHandler {

    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);


    @Autowired
    private AdminService adminService;

    @RequestMapping("test/ssm.html")
    public String testSSM(ModelMap modelMap){
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList",adminList);
        System.out.println(10/0);
        return "target";

    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }


    @ResponseBody
    @RequestMapping("/send/array2.do")
    public Admin testReceiveArrayTwo(@RequestBody List<Integer> array){

        for (Integer number : array){
            logger.info("number="+number); //注意是 org.slf4j.Logger，不是jul中的Logger
        }
        return new Admin(1,"1","1","1","1","1");
    }

//    @ResponseBody
//    @RequestMapping("/send/compose/object.do")
//    public ResultEntity<Student> testReceiveComplicatedObject(@RequestBody Student student){
//        logger.info(student.toString());
//        return ResultEntity.successWithData(student);
//    }

    @ResponseBody
    @RequestMapping("/send/compose/object.do")
    public ResultEntity<Student> testReceiveComplicatedObject(@RequestBody Student student, HttpServletRequest request){

        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        logger.info("judgeResult = "+judgeResult);

        logger.info(student.toString());
        return ResultEntity.successWithData(student);
    }

//    @RequestMapping("/test/ssm.html")
//    public String testSSM(ModelMap modelMap, HttpServletRequest request){
//
//        boolean judgeResult = CrowdUtil.judgeRequestType(request);
//        logger.info("judgeResult = "+judgeResult);
//
//        List<Admin> adminList = adminService.getAll();
//        modelMap.addAttribute("adminList",adminList);
//        return "target";
//    }


}
