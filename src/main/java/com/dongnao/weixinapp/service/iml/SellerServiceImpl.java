package com.dongnao.weixinapp.service.iml;

import com.dongnao.weixinapp.dataobject.SellerInfo;
import com.dongnao.weixinapp.repository.SellerInfoRepository;
import com.dongnao.weixinapp.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 廖师兄
 * 2017-07-29 23:15
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
