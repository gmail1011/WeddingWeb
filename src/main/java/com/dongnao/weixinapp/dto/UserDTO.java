package com.dongnao.weixinapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userId;
    private String weixinName;
    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private Integer gender;


}
