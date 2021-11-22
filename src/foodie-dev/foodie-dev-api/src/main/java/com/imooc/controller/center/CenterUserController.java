package com.imooc.controller.center;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户信息接口", tags = {"用户信息相关接口"})
@RequestMapping("center")
public class CenterUserController {

    @Autowired
    private CenterUserService centerUserService;

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod ="GET")
    @GetMapping("update")
    public IMOOCJSONResult update(@ApiParam(name = "userId", value = "用户id", required = true)  @RequestParam String userId, @RequestBody @Valid CenterUserBO centerUserBO, BindingResult result, HttpServletRequest req, HttpServletResponse rsp) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return IMOOCJSONResult.errorMap(errorMap);
        }
        Users user = centerUserService.updateUserInfo(userId, centerUserBO);
        user = setNullProperty(user);
        CookieUtils.setCookie(req, rsp, "user", JsonUtils.objectToJson(user), true);
        return IMOOCJSONResult.ok(user);
    }

    private Map<String, String> getErrors(BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, String> map = new HashMap<>();
        for (FieldError error : fieldErrors) {
            // 发生验证错误对应的某个属性
            String errorField = error.getField();
            String errorMsg = error.getDefaultMessage();
            map.put(errorField, errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
