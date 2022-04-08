package com.atguigu.crowd;


import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.mvc.handler.MenuHandler;
import com.atguigu.crowd.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml", "classpath:spring-persist-mybatis.xml","classpath:spring-web-mvc.xml"})
public class menuTest {
    @Autowired
    MenuHandler menu;
    @Test
    public void test(){
        menu.getWholeTreeNew();
    }
}
