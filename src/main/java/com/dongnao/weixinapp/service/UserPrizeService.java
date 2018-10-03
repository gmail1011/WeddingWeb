package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.UserPrizeInfo;
import com.dongnao.weixinapp.dto.UserPrizeDTO;

import java.util.List;

public interface UserPrizeService {

      void insertFrezzList(UserPrizeInfo userPrizeInfo);

    List<UserPrizeDTO> listPrize(String userId);
}
