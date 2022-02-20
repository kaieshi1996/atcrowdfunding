package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.RoleService;
import com.atguigu.crowd.util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleHandler {
    @Autowired
    public RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(@RequestParam(value = "keyword",defaultValue = "") String keyword,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        PageInfo<Role> pageInfo = roleService.getPageInfo(keyword,pageNum,pageSize);

        // 封装代码，如果有异常则交给springmvc的异常处理机制进行处理
        return ResultEntity.successWithData(pageInfo);
    }

}
