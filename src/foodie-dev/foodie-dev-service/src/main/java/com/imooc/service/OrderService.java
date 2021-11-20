package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.SubmitOrderBO;

import java.util.List;

public interface OrderService {

    public String createOrder(SubmitOrderBO submitOrderBO);

    // 修改订单状态
    public void updateOrderStatus(String orderId, Integer orderStatus);
}
