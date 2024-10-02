package com.springboot.payment.payment_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_orders")
public class StudentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private  String name;
    private  String email;
    private  String phoneNumber;
    private  String course;
    private  Integer amount;
    private  String orderStatus;
    private  String razorpayOrderId;

    public StudentOrder(){
        super();
    }

    public StudentOrder(Integer orderId, String name, String email, String phoneNumber, String course,
                        Integer amount, String orderStatus, String razorpayOrderId) {
        this.orderId = orderId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.razorpayOrderId = razorpayOrderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    @Override
    public String toString() {
        return "StudentOrder{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", course='" + course + '\'' +
                ", amount=" + amount +
                ", orderStatus='" + orderStatus + '\'' +
                ", razorpayOrderId='" + razorpayOrderId + '\'' +
                '}';
    }
}
