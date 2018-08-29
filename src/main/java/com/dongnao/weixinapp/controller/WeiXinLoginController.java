package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.dto.UserDTO;
import com.dongnao.weixinapp.service.UserService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class WeiXinLoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    @ResponseBody
    public ResultVO login(@RequestParam("avatarUrl") String avatarUrl
                                ,@RequestParam("city")String city
                                ,@RequestParam("country")String country
                                ,@RequestParam("gender")Integer gender
                                ,@RequestParam("nickName")String nickName
                                ,@RequestParam("province")String province ) {
        System.out.println("--------------------------");
        UserDTO userDTO = new UserDTO();
        userDTO.setAvatarUrl(avatarUrl);
        userDTO.setCity(city);
        userDTO.setCountry(country);
        userDTO.setGender(gender);
        userDTO.setGender(gender);
        userDTO.setWeixinName(nickName);
        userDTO.setProvince(province);
        System.out.println(userDTO);
        UserDTO userDTO1=userService.create(userDTO);
        return ResultVOUtil.success(userDTO1);
    }

}
