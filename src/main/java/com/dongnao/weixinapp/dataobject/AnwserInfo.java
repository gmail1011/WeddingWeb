package com.dongnao.weixinapp.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
@DynamicUpdate
@Data
@Entity
public class AnwserInfo {
    @Id
    private String anwserId;
    private  Integer anwserType;
    private String title;
    private String content;
    private String A;
    private String B;
    private String C;
    private String D;
    private String helpContent;
    private String rightContent;
    private int rightIndex;//1  选择题  2  点赞题   3   问答题
}
