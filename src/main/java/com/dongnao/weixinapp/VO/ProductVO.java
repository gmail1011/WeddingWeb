package com.dongnao.weixinapp.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {
    @JsonProperty("name")
    private String cateoryName;
    @JsonProperty("type")
    private String catetoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
