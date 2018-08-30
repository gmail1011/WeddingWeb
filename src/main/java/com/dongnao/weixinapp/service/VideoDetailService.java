package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dto.VideoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by 廖师兄
 * 2017-06-11 18:23
 */
public interface VideoDetailService {
    
    /** 创建订单. */
    VideoDto create(VideoDto videoInfo);

    /** 查询单个订单. */
    VideoDto findOne(String orderId);


    /** 取消订单. */
    VideoDto cancel(VideoDto videoInfo);

    /** 完结订单. */
    VideoDto finish(VideoDto videoInfo);

    /** 支付订单. */
    VideoDto paid(VideoDto videoInfo);

    /** 查询订单列表. */
    Page<VideoDto> findList(Pageable pageable);

}
