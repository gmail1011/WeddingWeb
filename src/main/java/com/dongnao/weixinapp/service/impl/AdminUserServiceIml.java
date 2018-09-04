package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.AdminUser;
import com.dongnao.weixinapp.repository.AdminUserRepository;
import com.dongnao.weixinapp.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminUserServiceIml implements AdminUserService {
    @Autowired
    private AdminUserRepository weixinUserRepository;
    @Override
    public boolean findUser(String name, String password) {
        AdminUser user = new AdminUser();
        user.setUserName(user.getUserName());
        Example<AdminUser> example = Example.of(user);
        AdminUser dataUser = weixinUserRepository.findOne(example).get();
        if (dataUser != null) {
            if (dataUser.getUserPassword().equals(password)) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }

    }
}
