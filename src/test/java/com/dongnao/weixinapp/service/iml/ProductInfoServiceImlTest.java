package com.dongnao.weixinapp.service.iml;

import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.dataobject.ProductInfo;
import com.dongnao.weixinapp.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImlTest {
    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findOne() {
    }

    @Test
    public void findUpAll() {
    }

    @Test
    public void save() {
        ProductInfo productCategory = new ProductInfo();
        productCategory.setProductId("12345687");
        productCategory.setProductName("皮蛋瘦肉粥");
        productCategory.setProductPrice(new BigDecimal(4.8));
        productCategory.setProductStock(100);
        productCategory.setProductStatus(0);
        productCategory.setProductIcon("http://image");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findOne1() {
    }

    @Test
    public void findUpAll1() {
    }

    @Test
    public void save1() {
    }

    @Test
    public void findAll1() {
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }
}