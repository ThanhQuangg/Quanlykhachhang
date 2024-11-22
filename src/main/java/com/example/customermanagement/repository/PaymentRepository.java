package com.example.customermanagement.repository;

import com.example.customermanagement.pojo.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    List<Payment> findByProjectId(Integer projectId);
    List<Payment> findByPaymentStatus(String paymentStatus);
    List<Payment> findByCustomerId(Integer customerId);
    List<Payment> findByPaymentStatusAndCustomerId(String paymentStatus, Integer customerId);
}
