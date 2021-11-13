package com.imooc.service;

import com.imooc.pojo.Category;

import java.util.List;

public interface CategoryService {

    // 查询一级分类
    public List<Category> queryAllRootLevelCat();

}
