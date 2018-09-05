package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.PrizeInfo;

import java.util.List;

public interface PrizeInfoService {
    public List<PrizeInfo> list();

    public void addPrize(PrizeInfo prizeInfo);
}
