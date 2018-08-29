package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dto.UserDTO;

public interface UserService {
    /** 创建订单. */
    UserDTO create(UserDTO userDTO);
}
