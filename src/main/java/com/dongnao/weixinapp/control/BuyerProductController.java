package com.dongnao.weixinapp.control;

import com.dongnao.weixinapp.VO.ProductInfoVO;
import com.dongnao.weixinapp.VO.ProductVO;
import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.dataobject.ProductCategory;
import com.dongnao.weixinapp.dataobject.ProductInfo;
import com.dongnao.weixinapp.service.CategoryService;
import com.dongnao.weixinapp.service.ProductService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryList=productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> categories=categoryService.findByCategoryTypeIn(categoryList);
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory category : categories) {
            ProductVO productVO = new ProductVO();
            productVO.setCateoryName(category.getCategoryName());
            productVO.setCatetoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productIn : productInfoList) {
                if (productIn.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoVO productInfo = new ProductInfoVO();
                    BeanUtils.copyProperties(productIn, productInfo);
                    productInfoVOList.add(productInfo);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

}
