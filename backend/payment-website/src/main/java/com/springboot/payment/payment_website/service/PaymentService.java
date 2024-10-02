package com.springboot.payment.payment_website.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.springboot.payment.payment_website.entity.TransactionDetails;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private static final String razorpayKeyId = "rzp_test_wRZmGuu081rGQe";
    private static final String razorpayKeySecret= "yPpkqfWjypvNvH3Rs46m3GMZ";

    private  static final String CURRENCY = "INR";

    //private RazorpayClient client;

//    public PaymentService() throws RazorpayException {
//        this.client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
//    }

//    public Map<String, Object> createOrder(double amount, String currency) throws RazorpayException {
//        Map<String, Object> response = new HashMap<>();
//
//        // Convert amount to the smallest currency unit (Razorpay accepts amounts in paise)
//        int amountInPaise = (int) (amount * 100);
//
//        JSONObject options = new JSONObject();
//        options.put("amount", amountInPaise); // amount in paise
//        options.put("currency", currency);
//        options.put("receipt", "txn_123456");
//        options.put("payment_capture", true); // automatic capture
//
//        Order order = client.orders.create(options);
//
//        response.put("id", order.get("id"));
//        response.put("currency", order.get("currency"));
//        response.put("amount", order.get("amount"));
//        response.put("status", order.get("status"));
//
//        return response;
//    }

    public TransactionDetails createTransaction(Double amount){
        //amount , currency , key , secretKey

        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", amount * 100);
            jsonObject.put("currency", CURRENCY);

            RazorpayClient razorpayClient =new RazorpayClient(razorpayKeyId,razorpayKeySecret);

           Order order = razorpayClient.orders.create(jsonObject);

          TransactionDetails transactionDetails = prepareTransactionDetails(order);

          return  transactionDetails;

        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        return  null;
    }

    private  TransactionDetails prepareTransactionDetails(Order order){
        String orderId = order.get("id");
        String currency = order.get("currency");
        Integer amount = order.get("amount");

        TransactionDetails transactionDetails = new TransactionDetails(orderId , currency , amount ,razorpayKeyId);
        return  transactionDetails ;

    }
}