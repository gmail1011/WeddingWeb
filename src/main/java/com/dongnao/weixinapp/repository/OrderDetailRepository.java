package com.dongnao.weixinapp.repository;

import com.dongnao.weixinapp.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
//    findByOrOrderByOrderId
    List<OrderDetail> findByOrderId(String orderId);
}
