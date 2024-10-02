package com.springboot.payment.payment_website.service;

import com.razorpay.Order;
import com.springboot.payment.payment_website.Repository.OrderDetailsRepository;
import com.springboot.payment.payment_website.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    public ResponseEntity<?> saveOrderDetails(OrderDetails orderDetails){
        orderDetailsRepository.save(orderDetails);
        return ResponseEntity.ok("OrderDetails saved successfully.");
    }
}
