package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.converter.OrderMaster2OrderDTOConverter;
import com.dongnao.weixinapp.dataobject.VideoInfo;
import com.dongnao.weixinapp.dto.VideoDto;
import com.dongnao.weixinapp.repository.VideoInfoRespository;
import com.dongnao.weixinapp.service.VideoDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-06-11 18:43
 */
@Service
@Slf4j
public class VideoDetailServiceImpl implements VideoDetailService {
    @Autowired
    private VideoInfoRespository videoInfoRespository;
    @Override
    public VideoDto create(VideoDto videoInfo) {

        return null;
    }

    @Override
    public VideoDto findOne(String orderId) {
        return null;
    }



    @Override
    public VideoDto cancel(VideoDto videoInfo) {
        return null;
    }

    @Override
    public VideoDto finish(VideoDto videoInfo) {
        return null;
    }

    @Override
    public VideoDto paid(VideoDto videoInfo) {
        return null;
    }

    @Override
    public Page<VideoDto> findList(Pageable pageable) {
        Page<VideoInfo> orderMasterPage = videoInfoRespository.findAll(pageable);
        List<VideoDto> orderDTOList = OrderMaster2OrderDTOConverter.convertVideo( orderMasterPage.getContent());
        return new PageImpl<>(orderDTOList, pageable, orderMasterPage.getTotalElements());
    }
}
