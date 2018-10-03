package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.PrizeInfo;
import com.dongnao.weixinapp.repository.PrizeInfoRepository;
import com.dongnao.weixinapp.service.PrizeInfoService;
import com.dongnao.weixinapp.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    @Override
    public void deletePush(String prizeId) {
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.setPrizeId(prizeId);
        prizeInfoRepository.delete(prizeInfo);
    }

    @Override
    public void deletePrize(String answerId) {
        prizeInfoRepository.deleteById(answerId);
    }

    @Override
    public void create(PrizeInfo prizeInfo) {
        String orderId = KeyUtil.genUniqueKey();
        prizeInfo.setPrizeId(orderId);
        prizeInfoRepository.save(prizeInfo);
    }

    @Override
    public List<PrizeInfo> listFrezz() {
        PrizeInfo where = new PrizeInfo();
        where.setState(1);
        Example<PrizeInfo> example = Example.of(where);
        return prizeInfoRepository.findAll(example);
    }

}
