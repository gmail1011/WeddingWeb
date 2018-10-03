package com.dongnao.weixinapp.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class PrizeInfo {
    @Id
    private String prizeId;
    private String prizeName;

    /** 创建时间. */
    private String prizeImg;
    private Integer prizeNumber;

    private Integer state;


}
