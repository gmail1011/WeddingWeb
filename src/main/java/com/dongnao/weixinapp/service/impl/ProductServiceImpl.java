package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.ProductInfo;
import com.dongnao.weixinapp.dto.CartDTO;
import com.dongnao.weixinapp.enums.ProductStatusEnum;
import com.dongnao.weixinapp.enums.ResultEnum;
import com.dongnao.weixinapp.exception.SellException;
import com.dongnao.weixinapp.repository.ProductInfoRepository;
import com.dongnao.weixinapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-05-09 17:31
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo where = new ProductInfo();
        where.setProductId(productId);
        Example<ProductInfo> example = Example.of(where);
        return repository.findOne(example).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        ProductInfo where = new ProductInfo();
        for (CartDTO cartDTO: cartDTOList) {

            where.setProductId(cartDTO.getProductId());
            Example<ProductInfo> example = Example.of(where);
            ProductInfo productInfo = repository.findOne(example).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        ProductInfo where = new ProductInfo();
        for (CartDTO cartDTO: cartDTOList) {
            where.setProductId(cartDTO.getProductId());
            Example<ProductInfo> example = Example.of(where);
            ProductInfo productInfo = repository.findOne(example).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo where = new ProductInfo();
        where.setProductId(productId);
        Example<ProductInfo> example = Example.of(where);
        ProductInfo productInfo = repository.findOne(example).get();
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo where = new ProductInfo();
        where.setProductId(productId);
        Example<ProductInfo> example = Example.of(where);
        ProductInfo productInfo = repository.findOne(example).get();
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
