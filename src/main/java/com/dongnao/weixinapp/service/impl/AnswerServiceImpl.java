package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.AnwserInfo;
import com.dongnao.weixinapp.repository.AnswerRepository;
import com.dongnao.weixinapp.service.AnswerService;
import com.dongnao.weixinapp.service.MyWebSocket;
import com.dongnao.weixinapp.utils.JsonUtil;
import com.dongnao.weixinapp.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    private MyWebSocket myWebSocket;
    @Override
    public List<AnwserInfo> findList() {
        return answerRepository.findAll();
    }

    @Override
    public AnwserInfo create(AnwserInfo answerVo) {
        HashMap map = new HashMap();
        map.put("", "");
        String orderId = KeyUtil.genUniqueKey();
        answerVo.setAnwserId(orderId);
        answerRepository.save(answerVo);
        return answerVo;
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
        System.out.println("-----准备发送消息  "+data);
//        webWeixinSocket.sendMessage(data);
        return true;
    }

    @Override
    public boolean deletePush(String anwserId) {
        System.out.println("===========>  "+anwserId);
        answerRepository.deleteById(anwserId);
        return true;
    }
}
