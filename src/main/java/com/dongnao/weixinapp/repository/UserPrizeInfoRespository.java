package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.UserPrizeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrizeInfoRespository extends JpaRepository<UserPrizeInfo, String> {
}
