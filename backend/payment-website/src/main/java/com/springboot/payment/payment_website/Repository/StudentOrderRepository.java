package com.springboot.payment.payment_website.Repository;

import com.springboot.payment.payment_website.entity.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentOrderRepository extends JpaRepository<StudentOrder ,Integer> {


}
