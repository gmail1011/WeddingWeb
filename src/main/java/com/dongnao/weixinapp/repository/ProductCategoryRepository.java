package com.dongnao.weixinapp.repository;


import com.dongnao.weixinapp.dataobject.ProductCategory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer> {

    @Override
    List<ProductCategory> findAllById(Iterable<Integer> iterable);
}
