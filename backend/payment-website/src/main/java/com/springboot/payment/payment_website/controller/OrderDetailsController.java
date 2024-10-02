package com.springboot.payment.payment_website.controller;

import com.razorpay.Order;
import com.springboot.payment.payment_website.entity.OrderDetails;
import com.springboot.payment.payment_website.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order/api")
@CrossOrigin
public class OrderDetailsController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/save")
    public ResponseEntity<?> addOrderDetails(@RequestBody OrderDetails orderDetails){
        return orderDetailService.saveOrderDetails(orderDetails);
    }
}
