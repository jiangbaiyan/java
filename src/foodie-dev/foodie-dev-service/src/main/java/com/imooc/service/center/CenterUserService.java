package com.imooc.service.center;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface CenterUserService {

    // 根据用户id查询用户信息
    public Users queryUserInfo(String userId);


}
