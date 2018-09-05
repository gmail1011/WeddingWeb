package com.dongnao.weixinapp.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@DynamicUpdate
@Data
@Entity
public class AnwserHistory {
    @Id
    private String anwserId;
    private  String userId;
    private Integer anwserNumber;
    private String prizeId ;
    private String Anwser;
    private String rightAnwser;
    private Integer isRight;
}
