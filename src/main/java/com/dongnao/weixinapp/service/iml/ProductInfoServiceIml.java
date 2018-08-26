package com.dongnao.weixinapp.service.iml;

import com.dongnao.weixinapp.dataobject.ProductCategory;
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

import java.util.List;
import java.util.Optional;
@Service
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

    public List<ProductInfo> findUpAll() {
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

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        ProductInfo where = new ProductInfo();
        for (CartDTO cartDTO : cartDTOList) {
            where.setProductId(cartDTO.getProductId());
            Example<ProductInfo> example = Example.of(where);
            ProductInfo productInfo1 = repository.findOne(example).get();
            Integer result=productInfo1.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
            }
            productInfo1.setProductStock(result);
            repository.save(productInfo1);
        }
    }


}
