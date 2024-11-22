package com.example.customermanagement.service;

import com.example.customermanagement.pojo.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    List<Payment> getPaymentsByStatus(String paymentStatus);
    List<Payment> getPaymentsByCustomerId(Integer customerId);
    List<Payment> getPaymentsByStatusAndCustomerId(String paymentStatus, Integer customerId);
    List<Payment> getPaymentsByProjectId(Integer projectId);
    Payment createPayment(Payment payment);
    Payment updatePaymentStatus(Integer paymentId, String paymentStatus);
    void calculateInstallmentAmount(Payment payment);
}