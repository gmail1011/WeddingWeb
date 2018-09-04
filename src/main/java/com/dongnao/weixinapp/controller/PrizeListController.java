package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.service.AnswerService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 卖家端订单
 * Created by 廖师兄
 * 2017-07-16 17:24
 */
@Controller
@RequestMapping("/v1/users")
@Slf4j
public class PrizeListController {

    @Autowired
    private AnswerService answerService;
    /**
     * 订单列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultVO list() {
        return ResultVOUtil.success(answerService.findList());
    }
    @GetMapping("/pushAnswer")
    @ResponseBody
    public ResultVO pushAnswer(@RequestParam("answerId") String answerId) {
        boolean success=answerService.pushService(answerId);
        return ResultVOUtil.success(success);
    }
}
