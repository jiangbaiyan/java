package com.imooc.service;

import com.imooc.pojo.Items;
import com.imooc.pojo.ItemsImg;
import com.imooc.pojo.ItemsParam;
import com.imooc.pojo.ItemsSpec;
import com.imooc.pojo.vo.CommentLevelCountsVO;
import com.imooc.pojo.vo.ShopcartVO;
import com.imooc.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    // 根据商品id查询详情
    public Items queryItemById(String itemId);

    // 根据商品id查询商品图片列表
    public List<ItemsImg> queryItemImgList(String itemId);

    // 根据商品id查询商品规格
    public List<ItemsSpec> queryItemSpecList(String itemId);

    // 根据商品id查询商品参数
    public ItemsParam queryItemParam(String itemId);

    // 根据商品id查询商品评价等级数量
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    // 根据商品id查询商品评价
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    // 搜索商品列表
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    // 根据分类id搜索商品列表
    public PagedGridResult searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    // 根据规格ids查询最新的购物车商品数据
    public List<ShopcartVO> queryItemsBySpecIds(String specIds);

    // 根据规格id查询规格详情
    public ItemsSpec queryItemSpecById(String specId);

    // 根据商品id获取商品主图url
    public String queryItemMainImgById(String itemId);

}
