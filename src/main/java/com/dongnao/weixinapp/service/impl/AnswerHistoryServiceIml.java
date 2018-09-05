package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.AnwserHistory;
import com.dongnao.weixinapp.dataobject.AnwserInfo;
import com.dongnao.weixinapp.dataobject.PrizeInfo;
import com.dongnao.weixinapp.dto.AnswerHistoryDTO;
import com.dongnao.weixinapp.dto.UserDTO;
import com.dongnao.weixinapp.repository.AnswerHistoryRepository;
import com.dongnao.weixinapp.repository.AnswerRepository;
import com.dongnao.weixinapp.repository.PrizeInfoRepository;
import com.dongnao.weixinapp.service.AnswerHistoryService;
import com.dongnao.weixinapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnswerHistoryServiceIml implements AnswerHistoryService {
    @Autowired
    private AnswerHistoryRepository answerHistoryRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    PrizeInfoRepository prizeInfoRepository;
    @Autowired
    private UserService userService;
    @Override
    public AnwserHistory create(AnwserHistory orderDTO) {
//        String orderId = KeyUtil.genUniqueKey();
        AnwserInfo anwserInfo = answerRepository.findById(orderDTO.getAnwserId()).get();
        orderDTO.setRightAnwser(anwserInfo.getRightContent());
        if (anwserInfo.getRightContent().equals(orderDTO.getAnwser())) {
//            答对了
            orderDTO.setIsRight(1);
        }else {
//            答错了
            orderDTO.setIsRight(0);
        }
        answerHistoryRepository.save(orderDTO);
        return answerHistoryRepository.save(orderDTO);
    }

    @Override
    public List<AnswerHistoryDTO> list(String anwserId) {
        AnwserHistory where = new AnwserHistory();
        where.setAnwserId(anwserId);
        Example<AnwserHistory> example = Example.of(where);
        List<AnwserHistory> list = answerHistoryRepository.findAll(example);
        List<AnswerHistoryDTO> reslutList = new ArrayList<>();
        for (AnwserHistory answerHistory : list) {
            UserDTO userDTO = userService.find(answerHistory.getUserId());
            PrizeInfo prizeInfo = prizeInfoRepository.findById(answerHistory.getPrizeId()).get();
            AnswerHistoryDTO answerHistoryDTO = new AnswerHistoryDTO();
            BeanUtils.copyProperties(answerHistory, answerHistoryDTO);
            answerHistoryDTO.setUserImg(userDTO.getAvatarUrl());
            answerHistoryDTO.setUserName(userDTO.getWeixinName());
            answerHistoryDTO.setPrizeName(prizeInfo.getPrizeName());
            answerHistoryDTO.setPrizeImg(prizeInfo.getPrizeImg());
            reslutList.add(answerHistoryDTO);
        }
        return reslutList ;
    }
}
