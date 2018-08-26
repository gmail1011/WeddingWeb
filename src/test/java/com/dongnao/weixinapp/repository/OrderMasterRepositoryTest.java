package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    OrderMasterRepository repository;

    private final String OPENID = "110110";

    @Test
    public void findByBuyeAndBuyerOpenid() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12342567");
        orderMaster.setBuyerName("师兄2");
        orderMaster.setBuyerPhone("1234567891213");
        orderMaster.setBuyerAddress("幕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);

    }
}