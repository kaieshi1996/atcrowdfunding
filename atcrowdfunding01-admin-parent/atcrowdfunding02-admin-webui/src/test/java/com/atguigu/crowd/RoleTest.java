package com.atguigu.crowd;


import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;

@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml", "classpath:spring-persist-mybatis.xml"})
public class RoleTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;

    @Test
    public void insert(){
        Role role;
        for(int i = 0;i<200;i++){
            role = new Role(null,"role"+i);
            roleMapper.insert(role);
        }
    }
}
