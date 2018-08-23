package com.dongnao.weixinapp.control;

import com.dongnao.weixinapp.VO.ProductVO;
import com.dongnao.weixinapp.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultVO list() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("返回成功");
        ProductVO productVO = new ProductVO();
        productVO.setCateoryName("热销榜");
        productVO.setCateoryName("1");
        productVO.setProductInfoVOList(new ArrayList<>());
        resultVO.setData(productVO);
        return resultVO;
    }
}
