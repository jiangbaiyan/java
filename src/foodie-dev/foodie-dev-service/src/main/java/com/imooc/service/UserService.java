package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {

    // 判断用户名是否存在
    public boolean queryUsernameIsExist(String username);

    public Users createUser(UserBO userBO);
}
