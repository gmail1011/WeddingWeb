package com.dongnao.weixinapp.service;

import com.dongnao.weixinapp.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    Page<ProductInfo> findAll(Pageable pageable);
}
