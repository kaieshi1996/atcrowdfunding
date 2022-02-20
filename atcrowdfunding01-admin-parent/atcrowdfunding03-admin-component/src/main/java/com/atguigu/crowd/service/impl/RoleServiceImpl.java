package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.mvc.handler.TestHandler;
import com.atguigu.crowd.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final Logger logger = LoggerFactory.getLogger(TestHandler.class);
    @Autowired
    public RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        // 执行查询
        List<Role> roleList = roleMapper.selectRoleByKeyword(keyword);

        return new PageInfo<>(roleList);
    }
}
