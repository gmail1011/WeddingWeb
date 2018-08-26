package com.dongnao.weixinapp.control;

import com.dongnao.weixinapp.VO.ResultVO;
import com.dongnao.weixinapp.converter.OrderForm2OrderDTOConverter;
import com.dongnao.weixinapp.dto.OrderDTO;
import com.dongnao.weixinapp.enums.ResultEnum;
import com.dongnao.weixinapp.exception.SellException;
import com.dongnao.weixinapp.form.OrderForm;
import com.dongnao.weixinapp.service.BuyerService;
import com.dongnao.weixinapp.service.OrderService;
import com.dongnao.weixinapp.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //    创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

//    订单列表
@PostMapping("/list")
public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size) {
    if (StringUtils.isEmpty(openid)) {
        log.error("【查询订单列表】openid为空");
        throw new SellException(ResultEnum.PARAM_ERROR);
    }
    PageRequest request = new PageRequest(page, size);
    Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
    return ResultVOUtil.success(orderDTOPage.getContent());

}



    //订单详情
    @PostMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtil.success(orderDTO);
    }

//    订单详情


//    取消清单

    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.cancelOrder(openid,orderId);
        return ResultVOUtil.success("");
    }
}
