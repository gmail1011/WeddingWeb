package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {
}
