package com.imooc.service;

import com.imooc.pojo.Carousel;
import com.imooc.pojo.bo.SubmitOrderBO;

import java.util.List;

public interface OrderService {

    public void createOrder(SubmitOrderBO submitOrderBO);
}
