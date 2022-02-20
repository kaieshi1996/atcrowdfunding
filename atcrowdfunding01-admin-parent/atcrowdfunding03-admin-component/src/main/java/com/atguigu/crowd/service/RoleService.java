package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService {
    PageInfo<Role> getPageInfo(String keyword, Integer pageNum, Integer pageSize);
}
