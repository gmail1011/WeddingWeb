package com.dongnao.weixinapp.service.impl;

import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.repository.ProductCategoryRepository;
import com.dongnao.weixinapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import java.util.List;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-09 10:16
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory where = new ProductCategory();
        where.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(where);
        return repository.findOne(example).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
