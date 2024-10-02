package com.springboot.payment.payment_website.service;

import com.razorpay.RazorpayClient;
import com.springboot.payment.payment_website.Repository.StudentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Value("razorpay.key.id")
    private  String razorPayKey;
    @Value("razorpay.secret.key")
    private  String razorPaySecret;

    private RazorpayClient razorpayClient;


}
