package com.dongnao.weixinapp.service.iml;

import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.dataobject.ProductInfo;
import com.dongnao.weixinapp.enums.ProductStatusEnum;
import com.dongnao.weixinapp.repository.ProductInfoRepository;
import com.dongnao.weixinapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ProductInfoServiceIml implements ProductService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo person = new ProductInfo();
        person.setProductId(productId);
        Example<ProductInfo> example = Example.of(person);
        Optional<ProductInfo> productCategory = repository.findOne(example);
        return productCategory.get();
    }

    @Override
    public List<ProductInfo> findUpAll(Pageable pageable) {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }



    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }


}
