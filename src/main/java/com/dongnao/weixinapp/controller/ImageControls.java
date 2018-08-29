package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ImageItemVo;
import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.constant.ServerConfig;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageControls {
    @GetMapping("/list")
    public ResultVO list() {
        List<ImageItemVo> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ImageItemVo imageItemVo = new ImageItemVo();

            imageItemVo.setUrl(ServerConfig.url + "img_" + i + ".jpg");

            list.add(imageItemVo);
        }

        return ResultVOUtil.success(list);
    }

}
