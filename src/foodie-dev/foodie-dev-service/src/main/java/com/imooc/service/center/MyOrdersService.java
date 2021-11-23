package com.imooc.service.center;

import com.imooc.utils.PagedGridResult;

public interface MyOrdersService {

    public PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);
}
