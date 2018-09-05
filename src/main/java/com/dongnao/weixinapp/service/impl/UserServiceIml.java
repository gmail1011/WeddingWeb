package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.User;
import com.dongnao.weixinapp.dto.UserDTO;
import com.dongnao.weixinapp.repository.WeixinUserRepository;
import com.dongnao.weixinapp.service.UserService;
import com.dongnao.weixinapp.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceIml implements UserService {
    @Autowired
    private WeixinUserRepository weixinUserRepository;
    @Override
    public UserDTO create(UserDTO userDTO) {
        User user = new User();
        user.setWeixinName(user.getWeixinName());
        Example<User> example = Example.of(user);
        User dataUser = weixinUserRepository.findOne(example).get();
        if (dataUser != null) {
            dataUser.setUpdateTime(new Date());
            weixinUserRepository.save(dataUser);
            BeanUtils.copyProperties(dataUser, userDTO);
        }else {
            String userId = KeyUtil.genUniqueKey();
            userDTO.setUserId(userId);
            dataUser = new User();
            BeanUtils.copyProperties(userDTO, dataUser);
            weixinUserRepository.save(dataUser);
        }
        return userDTO;
    }

    @Override
    public UserDTO find(String userId) {
        UserDTO userDTO = new UserDTO();
        User user = weixinUserRepository.findById(userId).get();

        if (user != null) {
            BeanUtils.copyProperties(user,userDTO);
        }
        return userDTO;
    }
}
