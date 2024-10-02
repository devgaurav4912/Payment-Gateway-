package com.springboot.payment.payment_website.Repository;

import com.springboot.payment.payment_website.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails , Integer> {
}
