package com.dongnao.weixinapp.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code=0;

    private String msg="";

    private T data;
}
