package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeixinUserRepository extends JpaRepository<User, String> {
}
