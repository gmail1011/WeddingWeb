package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.ProductInfo;
import com.dongnao.weixinapp.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    public List<ProductInfo> findUpAll();

    ProductInfo save(ProductInfo productInfo);

    Page<ProductInfo> findAll(Pageable pageable);

//    加库存

    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
