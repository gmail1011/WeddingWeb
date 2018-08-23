package com.dongnao.weixinapp.service.iml;

import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.repository.ProductCategoryRepository;
import com.dongnao.weixinapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory person = new ProductCategory();
        person.setCategoryId(categoryId);
        Example<ProductCategory> example = Example.of(person);
        Optional<ProductCategory> productCategory = repository.findOne(example);
        return productCategory.get();
    }

    @Override
    public List<ProductCategory> findAll() {

        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findAllById(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
