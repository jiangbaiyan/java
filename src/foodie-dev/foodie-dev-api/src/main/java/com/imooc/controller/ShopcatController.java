package com.imooc.controller;

import com.imooc.pojo.bo.ShopcartBO;
import com.imooc.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "购物车接口controller", tags = {"购物车接口相关的api"})
@RestController
@RequestMapping("shopcart")
public class ShopcatController {

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/add")
    public IMOOCJSONResult add(@RequestParam String userId, @RequestBody ShopcartBO shopcartBO, HttpServletRequest req, HttpServletResponse rsp) {

        if (StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("");
        }

        // TODO 前端用户在登录的情况下,添加商品到购物车,会同时在后端同步购物车到redis
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "POST")
    @PostMapping("/del")
    public IMOOCJSONResult del(@RequestParam String userId, @RequestParam String itemSpecId, HttpServletRequest req, HttpServletResponse rsp) {

        if (StringUtils.isBlank(userId) ||  (StringUtils.isBlank(itemSpecId))) {
            return IMOOCJSONResult.errorMsg("");
        }

        // TODO 用户已经登录，需要同步删除后端购物车中的商品
        return IMOOCJSONResult.ok();
    }
}
