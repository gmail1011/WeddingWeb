package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.VO.WeddingVo;
import com.dongnao.weixinapp.dataobject.AnwserHistory;
import com.dongnao.weixinapp.dataobject.AnwserInfo;
import com.dongnao.weixinapp.dataobject.PrizeInfo;
import com.dongnao.weixinapp.dto.AnswerHistoryDTO;
import com.dongnao.weixinapp.service.AnswerHistoryService;
import com.dongnao.weixinapp.service.AnswerService;
import com.dongnao.weixinapp.service.PrizeInfoService;
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
@RequestMapping("/v1/users")
@Slf4j
public class PrizeListController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerHistoryService answerHistoryService ;

    @Autowired
    private PrizeInfoService prizeInfoService;
    /**
     * 订单列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public ResultVO list() {
        return ResultVOUtil.success(answerService.findList());
    }
    @GetMapping("/getWedding")
    @ResponseBody
    public ResultVO getWedding() {
        WeddingVo weddingVo = new WeddingVo();
        weddingVo.setAddress("石首市新厂镇上闸村4组");
        weddingVo.setCover("https://dengpaoedu.com/main.jpg");
        weddingVo.setDate("2018-10-5");
        weddingVo.setHe("Mr 涂");
        weddingVo.setHe_tel("18175131772");
        weddingVo.setShe("Miss 胡");
        weddingVo.setLat("29.894485");
        weddingVo.setLng("112.475416");
        weddingVo.setShe_tel("18075131772");
        weddingVo.setMusic("http://dl.stream.qqmusic.qq.com/C100001J5QJL1pRQYB.m4a?fromtag=46");
        return ResultVOUtil.success(weddingVo);
    }
    @GetMapping("/answerQuestion")
    @ResponseBody
    public ResultVO answerQuestion(@RequestParam("userId") String userId,@RequestParam("answerId") String answerId,@RequestParam("answer") String answer,@RequestParam("prizeId") String prizeId) {
        AnwserHistory anwserHistory = new AnwserHistory();
        anwserHistory.setAnwserId(answerId);
        anwserHistory.setUserId(userId);
        anwserHistory.setAnwser(answer);
        anwserHistory.setPrizeId(prizeId);
        answerHistoryService.create(anwserHistory);
        return ResultVOUtil.success(answerService.findList());
    }
    @GetMapping("/pushAnswer")
    @ResponseBody
    public ResultVO pushAnswer(@RequestParam("answerId") String answerId) {
        boolean success=answerService.pushService(answerId);
        return ResultVOUtil.success(success);
    }

    @GetMapping("/questionList")
    @ResponseBody
    public ResultVO questionList(@RequestParam("answerId") String answerId) {
        boolean success=answerService.pushService(answerId);
        List<AnswerHistoryDTO> list= answerHistoryService.list(answerId);
        if (list == null || list.isEmpty()) {
            ResultVOUtil.error(-1, "没有数据");
        }
        return ResultVOUtil.success(list);
    }

    @GetMapping("/prizeList")
    @ResponseBody
    public ResultVO prizeList() {

        List<PrizeInfo> list= prizeInfoService.list();
        if (list == null || list.isEmpty()) {
            ResultVOUtil.error(-1, "没有数据");
        }
        return ResultVOUtil.success(list);
    }
    @GetMapping("/prizeFrezzList")
    @ResponseBody
    public ResultVO prizeFrezzList() {

        List<PrizeInfo> list= prizeInfoService.listFrezz();
        if (list == null || list.isEmpty()) {
            return  ResultVOUtil.error(-1, "没有数据");
        }
        return ResultVOUtil.success(list);
    }
    @GetMapping("/addPrize")
    @ResponseBody
    public ResultVO addPrize(String prizeName, String prizeImg, Integer prizeNumber,Integer anserType) {
        PrizeInfo prizeInfo = new PrizeInfo();
        prizeInfo.setPrizeImg(prizeImg);
        prizeInfo.setPrizeName(prizeName);
        prizeInfo.setPrizeNumber(prizeNumber);
        prizeInfo.setState(anserType);
        prizeInfoService.create(prizeInfo);
        return ResultVOUtil.success();
    }
    @GetMapping("/deletePrize")
    @ResponseBody
    public ResultVO deletePrize(String answerId) {
        prizeInfoService.deletePrize(answerId);
        return ResultVOUtil.success();
    }

    @GetMapping("/deletePush")
    @ResponseBody
    public ResultVO deletePush(String answerId) {
        answerService.deletePush(answerId);
        return ResultVOUtil.success();
    }


    @GetMapping("/submit")
    @ResponseBody
    public ResultVO submit(String title,Integer anserType,String prizeId,String content,
                           String rightContent,String helpContent,Integer times,
                           String A,String B,String C,String D) {
        AnwserInfo answerInfo = new AnwserInfo();
        answerInfo.setTitle(title);
        answerInfo.setAnwserType(anserType);
        answerInfo.setPrizeId(prizeId);
        answerInfo.setContent(content);
        answerInfo.setRightContent(rightContent);
        answerInfo.setHelpContent(helpContent);
        answerInfo.setTimes(times);
        answerInfo.setA(A);
        answerInfo.setB(B);
        answerInfo.setC(C);
        answerInfo.setD(D);
        try {
            answerService.create(answerInfo);
        } catch (Exception e) {
            ResultVOUtil.error(0, "失败");
        }
        return ResultVOUtil.success( );
    }
}
