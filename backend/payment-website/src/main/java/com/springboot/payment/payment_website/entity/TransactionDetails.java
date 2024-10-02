package com.springboot.payment.payment_website.entity;

import jakarta.persistence.Entity;


public class TransactionDetails {

    private String orderId;
    private String currency;
    private Integer amount;

    public TransactionDetails(String orderId, String currency, Integer amount) {
        this.orderId = orderId;
        this.currency = currency;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "orderId='" + orderId + '\'' +
                ", currency='" + currency + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
