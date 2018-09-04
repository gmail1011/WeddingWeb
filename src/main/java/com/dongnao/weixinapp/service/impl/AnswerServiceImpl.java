package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.AnwserInfo;
import com.dongnao.weixinapp.repository.AnswerRepository;
import com.dongnao.weixinapp.service.AnswerService;
import com.dongnao.weixinapp.service.WebSocket;
import com.dongnao.weixinapp.utils.JsonUtil;
import com.dongnao.weixinapp.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by 廖师兄
 * 2017-06-11 18:43
 */
@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private WebSocket webSocket;
    @Override
    public List<AnwserInfo> findList() {
        return answerRepository.findAll();
    }

    @Override
    public AnwserInfo create(AnwserInfo answerVo) {
        String orderId = KeyUtil.genUniqueKey();
        return null;
    }

    @Override
    public AnwserInfo cancel(AnwserInfo answerVo) {
        return null;
    }

    @Override
    public boolean pushService(String answerId) {
        Optional optional = answerRepository.findById(answerId);
        AnwserInfo anwserInfo = answerRepository.findById(answerId).get();
        if (anwserInfo == null) {
            return false;
        }
        String data = JsonUtil.toJson(anwserInfo);
        webSocket.sendMessage(data);
        return true;
    }
}
