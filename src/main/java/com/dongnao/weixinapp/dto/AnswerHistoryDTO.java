package com.dongnao.weixinapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AnswerHistoryDTO {
    private String anwserId;
    private  String userId;
    private Integer anwserNumber;
    private String prizeId ;
    private String Anwser;
    private String rightAnwser;
    private Integer isRight;


    private String userName;

    private String userImg;

    private Date times;
    private String prizeName;

    /** 创建时间. */
    private String prizeImg;
}
