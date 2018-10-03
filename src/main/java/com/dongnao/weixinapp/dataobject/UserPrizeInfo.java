package com.dongnao.weixinapp.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class UserPrizeInfo {
    @Id
    private String userprizeId;
    private String prizeId;
    private String userId;
//    次数
    private Integer times;
    /** 创建时间. */
    private Date createTime;
    /** 更新时间. */
    private Date updateTime;

}
