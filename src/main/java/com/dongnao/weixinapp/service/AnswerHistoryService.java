package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.AnwserHistory;
import com.dongnao.weixinapp.dto.AnswerHistoryDTO;

import java.util.List;

public interface AnswerHistoryService {
    /** 创建订单. */
    AnwserHistory create(AnwserHistory orderDTO);

    List<AnswerHistoryDTO> list(String  anwserId);


}
