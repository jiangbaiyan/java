package com.imooc.service;

import com.imooc.pojo.Category;
import com.imooc.pojo.vo.CategoryVO;
import com.imooc.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {

    // 查询一级分类
    public List<Category> queryAllRootLevelCat();

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    // 查询一级分类下的6条商品数据
    public List<NewItemsVO> getSixNexItemsLazy(Integer rootCatId);

}
