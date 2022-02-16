package com.atguigu.crowd.service;

import com.atguigu.crowd.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);
    List<Admin> getAll();
    Admin getAdminByLoginAcct(String loginAcct,String userPswd);
    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum, Integer pageSize);

    void remove(Integer adminId);
}
