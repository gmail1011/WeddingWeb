package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.dataobject.UserPrizeInfo;
import com.dongnao.weixinapp.dto.UserPrizeDTO;
import com.dongnao.weixinapp.service.PrizeInfoService;
import com.dongnao.weixinapp.service.UserPrizeService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 卖家端订单
 * Created by 廖师兄
 * 2017-07-16 17:24
 */
@Controller
@RequestMapping("/user/prize")
@Slf4j
public class UserPrizeController {

    @Autowired
    private UserPrizeService userPrizeService;


    @Autowired
    private PrizeInfoService prizeInfoService;

    @GetMapping("/listPrize")
    @ResponseBody
    public ResultVO listPrize(@RequestParam("userId") String userId) {
        List<UserPrizeDTO> userPrizeDTOs=userPrizeService.listPrize(userId);
        return ResultVOUtil.success(userPrizeDTOs);
    }
    @GetMapping("/addUserPrize")
    @ResponseBody
    public ResultVO addUserPrize(@RequestParam("userId") String userId,@RequestParam("prizeId") String prizeId) {
        UserPrizeInfo userPrizeInfo = new UserPrizeInfo();
        userPrizeInfo.setUserId(userId);
        userPrizeInfo.setPrizeId(prizeId);
         userPrizeService.insertFrezzList(userPrizeInfo);
        return ResultVOUtil.success();
    }
}
