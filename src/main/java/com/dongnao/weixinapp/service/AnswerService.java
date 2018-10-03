package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.AnwserInfo;

import java.util.List;

public interface AnswerService {
    /** 创建订单. */
    List<AnwserInfo> findList( );

    AnwserInfo create(AnwserInfo answerVo);
    /** 取消订单. */
    AnwserInfo cancel(AnwserInfo answerVo);

    boolean pushService(String answerId);

    boolean deletePush(String anwserId);
}
