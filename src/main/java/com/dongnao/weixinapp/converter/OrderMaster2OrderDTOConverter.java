package com.dongnao.weixinapp.converter;

import com.dongnao.weixinapp.constant.ServerConfig;
import com.dongnao.weixinapp.dataobject.OrderMaster;
import com.dongnao.weixinapp.dataobject.VideoInfo;
import com.dongnao.weixinapp.dto.OrderDTO;
import com.dongnao.weixinapp.dto.VideoDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 廖师兄
 * 2017-06-11 22:02
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }
    public static VideoDto convert(VideoInfo orderMaster) {

        VideoDto orderDTO = new VideoDto();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        orderDTO.setVideoUrl(ServerConfig.url + orderDTO.getVideoUrl());
        orderDTO.setVideoImgUrl(ServerConfig.url + orderDTO.getVideoImgUrl());
        return orderDTO;
    }
    public static List<VideoDto> convertVideo(List<VideoInfo> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
