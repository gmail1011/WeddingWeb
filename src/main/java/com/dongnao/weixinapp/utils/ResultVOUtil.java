package com.dongnao.weixinapp.utils;

import com.dongnao.weixinapp.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("返回成功");
        resultVO.setData(object);
        resultVO.setCode(0);
        return resultVO;
    }
    public static ResultVO fail(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("失败");
        resultVO.setData(object);
        resultVO.setCode(1);
        return resultVO;
    }
}
