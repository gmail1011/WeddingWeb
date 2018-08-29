package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dto.OrderDTO;
import com.dongnao.weixinapp.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 廖师兄
 * 2017-07-30 22:09
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements PushMessageService {



    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first", "亲，请记得收货。"),
                new WxMpTemplateData("keyword1", "微信点餐"),
                new WxMpTemplateData("keyword2", "18868812345"),
                new WxMpTemplateData("keyword3", orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4", orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5", "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark", "欢迎再次光临！")
        );
        templateMessage.setData(data);

    }
}
