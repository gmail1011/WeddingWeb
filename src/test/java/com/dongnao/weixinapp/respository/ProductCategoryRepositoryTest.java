package com.dongnao.weixinapp.respository;

import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Test
    public void test1(){
//        Logger logger = LoggerFactory.getLogger(LoogerTest.class);
//        logger.info("-------------info");
        ProductCategory person = new ProductCategory();
        person.setCategoryId(1);
        Example<ProductCategory> example = Example.of(person);
        Optional<ProductCategory> productCategory = productCategoryRepository.findOne(example);
        System.out.println("----->"+productCategory.get());
    }

    @Test
    public void test2(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("热门");
        productCategory.setCategoryType(3);

        productCategoryRepository.save(productCategory);
    }  @Test
    public void test3(){
        ProductCategory person = new ProductCategory();
        person.setCategoryId(1);
        Example<ProductCategory> example = Example.of(person);
        Optional<ProductCategory> productCategory = productCategoryRepository.findOne(example);
        ProductCategory productCategory1 = productCategory.get();
        productCategory1.setCategoryType(6);
        productCategoryRepository.save(productCategory1);
    }
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(1, 2);
        List<ProductCategory> list12= productCategoryRepository.findAllById(list);
        System.out.println("======"+list12.toString());
    }
}