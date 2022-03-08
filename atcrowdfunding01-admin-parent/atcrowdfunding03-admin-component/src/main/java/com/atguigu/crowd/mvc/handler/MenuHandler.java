package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.service.MenuService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuHandler {

    @Autowired
    public MenuService menuService;

    @ResponseBody
    @RequestMapping("/menu/get/whole/tree.json")
    public ResultEntity<Menu> getWholeTreeNew(){
        List<Menu> menuList = menuService.getAll();
        Menu root = null;
        Map<Integer,Menu> menuMap = new HashMap<>();
        for(Menu menu:menuList){
            Integer id = menu.getId();
            menuMap.put(id,menu);
        }
        for(Menu menu:menuList){
            Integer pid = menu.getPid();

            if(pid == null){
                root = menu;
                continue;
            }

            Menu father = menuList.get(pid);
            father.getChildren().add(menu);
        }

        return ResultEntity.successWithData(root);
    }
}
