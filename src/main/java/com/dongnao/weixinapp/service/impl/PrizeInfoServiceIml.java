package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.PrizeInfo;
import com.dongnao.weixinapp.repository.PrizeInfoRepository;
import com.dongnao.weixinapp.service.PrizeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class PrizeInfoServiceIml implements PrizeInfoService
{

    @Autowired
    PrizeInfoRepository prizeInfoRepository;
    @Override
    public List<PrizeInfo> list() {
        return prizeInfoRepository.findAll();
    }

    @Override
    public void addPrize(PrizeInfo prizeInfo) {
        prizeInfoRepository.save(prizeInfo);
    }
}
