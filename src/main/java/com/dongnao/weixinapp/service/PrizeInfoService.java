package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.PrizeInfo;

import java.util.List;

public interface PrizeInfoService {
    public List<PrizeInfo> list();

    public void addPrize(PrizeInfo prizeInfo);
    public void deletePush(String anwserId);

    void deletePrize(String answerId);

    void create(PrizeInfo prizeInfo);

    List<PrizeInfo> listFrezz();


}
