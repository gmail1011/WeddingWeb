package com.dongnao.weixinapp.controller;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.service.AdminUserService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 卖家端订单
 * Created by 廖师兄
 * 2017-07-16 17:24
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminLoginController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 订单列表
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public ResultVO login(@RequestParam() String username,
                         @RequestParam() String password
                       ) {
        if (adminUserService.findUser(username, password)) {
            return ResultVOUtil.success();
        }else {
            return ResultVOUtil.error(-1,"用户名密码不正确");
        }
    }
    @GetMapping("/info")
    @ResponseBody
    public ResultVO info() {
        return ResultVOUtil.success();
    }

}
