package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.dto.OrderDTO;
import com.dongnao.weixinapp.enums.ResultEnum;
import com.dongnao.weixinapp.exception.SellException;
import com.dongnao.weixinapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 * Created by 廖师兄
 * 2017-07-04 00:49
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1. 查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }
}
