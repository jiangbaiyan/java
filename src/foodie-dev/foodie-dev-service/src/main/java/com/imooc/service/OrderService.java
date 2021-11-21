package com.imooc.service;

import com.imooc.pojo.OrderStatus;
import com.imooc.pojo.bo.SubmitOrderBO;
import com.imooc.pojo.vo.OrdersVO;

import java.util.List;

public interface OrderService {

    public OrdersVO createOrder(SubmitOrderBO submitOrderBO);

    // 修改订单状态
    public void updateOrderStatus(String orderId, Integer orderStatus);

    // 查询订单状态
    public OrderStatus queryOrderStatusInfo(String orderId);

    // 关闭超时未支付订单
    public void closeOrder();
}
