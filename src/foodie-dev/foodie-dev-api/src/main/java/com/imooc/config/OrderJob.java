package com.imooc.config;

import com.imooc.service.OrderService;
import com.imooc.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderJob {

    @Autowired
    private OrderService orderService;

    // 问题1：不支持集群，需要挑一个节点专门执行定时任务
    // 问题2：全表扫描
    // 问题3：会有时间差，10:39下单，11:00检查不足一小时，12:00检查，超过1小时多余39分钟
    // 定时任务只用于小型轻量级项目，传统项目。后续采用延时队列（任务）10:12下单的，未付款（10）状态，11:12检查，如果当前状态还是未付款则直接关闭订单
    @Scheduled(cron = "0/3 * * * * ?")
    public void autoCloseOrder() {
        orderService.closeOrder();
        System.out.println("执行定时任务， 当前时间为:" + DateUtil.getCurrentDateString(DateUtil.DATETIME_PATTERN));
    }
}
