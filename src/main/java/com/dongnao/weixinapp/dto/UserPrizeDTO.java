package com.dongnao.weixinapp.dto;

import lombok.Data;

import javax.persistence.Id;

@Data
public class UserPrizeDTO {
    @Id
    private String userId;
    private String weixinName;
    private String avatarUrl;
    private Integer gender;

    private String prizeId;
    private String prizeName;

    /** 创建时间. */
    private String prizeImg;


}
