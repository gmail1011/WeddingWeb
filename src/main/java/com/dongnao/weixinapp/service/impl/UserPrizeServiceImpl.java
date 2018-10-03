package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.PrizeInfo;
import com.dongnao.weixinapp.dataobject.User;
import com.dongnao.weixinapp.dataobject.UserPrizeInfo;
import com.dongnao.weixinapp.dto.UserPrizeDTO;
import com.dongnao.weixinapp.repository.PrizeInfoRepository;
import com.dongnao.weixinapp.repository.UserPrizeInfoRespository;
import com.dongnao.weixinapp.repository.WeixinUserRepository;
import com.dongnao.weixinapp.service.UserPrizeService;
import com.dongnao.weixinapp.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserPrizeServiceImpl implements UserPrizeService {
    @Autowired
    UserPrizeInfoRespository userPrizeInfoRespository;
    @Autowired
    private WeixinUserRepository weixinUserRepository;
    @Autowired
    PrizeInfoRepository prizeInfoRepository;
    @Override
    public void insertFrezzList(UserPrizeInfo userPrizeInfo) {
        String orderId = KeyUtil.genUniqueKey();
        userPrizeInfo.setUserprizeId(orderId);
        userPrizeInfoRespository.save(userPrizeInfo);
    }

    @Override
    public List<UserPrizeDTO> listPrize(String userId) {
        UserPrizeInfo userPrizeInfo = new UserPrizeInfo();
        userPrizeInfo.setUserId(userId);
        Example<UserPrizeInfo> where = Example.of(userPrizeInfo);
        List<UserPrizeDTO> prizeDTOS = new ArrayList<>();
        List<UserPrizeInfo> list= userPrizeInfoRespository.findAll(where);
        for (UserPrizeInfo info : list) {
            UserPrizeDTO dto = new UserPrizeDTO();
            PrizeInfo prizeInfo=null;
            if ("-1".equals(info.getPrizeId())) {
                prizeInfo = new PrizeInfo();
                prizeInfo.setPrizeName("谢谢惠顾");
            }else {
                prizeInfo = prizeInfoRepository.findById(info.getPrizeId()).get();
            }
            User user = weixinUserRepository.findById(info.getUserId()).get();

            BeanUtils.copyProperties(user, dto);

            BeanUtils.copyProperties(prizeInfo, dto);
            prizeDTOS.add(dto);
        }
        return prizeDTOS;
    }
}
