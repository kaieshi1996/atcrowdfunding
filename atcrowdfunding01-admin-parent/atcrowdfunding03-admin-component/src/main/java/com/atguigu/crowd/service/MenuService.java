package com.atguigu.crowd.service;


import com.atguigu.crowd.entity.Menu;

import java.util.List;

public interface MenuService {

    public List<Menu> getAll();
    public void saveMenu(Menu menu);

    void update(Menu menu);

    void delete(Integer id);
}
