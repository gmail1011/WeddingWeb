package com.dongnao.weixinapp.dto;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class VideoDto {

    @Id
    private String videoId;
    private String videoUrl;
    private String videoImgUrl;
    private Integer videoPlayNumber;
    private String videoDescrption;
    private String videoUploadName;
    private String title;
    private Integer videoFavorate;
    private Integer videoSpack;
    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;
}
