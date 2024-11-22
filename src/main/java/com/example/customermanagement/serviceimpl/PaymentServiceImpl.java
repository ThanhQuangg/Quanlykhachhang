package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.Payment;
import com.example.customermanagement.repository.PaymentRepository;
import com.example.customermanagement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getPaymentsByStatus(String paymentStatus) {
        return paymentRepository.findByPaymentStatus(paymentStatus);
    }

    @Override
    public List<Payment> getPaymentsByCustomerId(Integer customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Payment> getPaymentsByStatusAndCustomerId(String paymentStatus, Integer customerId) {
        return paymentRepository.findByPaymentStatusAndCustomerId(paymentStatus, customerId);
    }

    @Override
    public List<Payment> getPaymentsByProjectId(Integer projectId) {
        return paymentRepository.findByProjectId(projectId);
    }

    @Override
    public Payment createPayment(Payment payment) {
        calculateInstallmentAmount(payment); // Tính số tiền mỗi đợt
        LocalDateTime currentTime = LocalDateTime.now();
        payment.setCreatedAt(currentTime);
        payment.setUpdatedAt(currentTime);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentStatus(Integer paymentId, String paymentStatus) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setPaymentStatus(paymentStatus);
            payment.setUpdatedAt(LocalDateTime.now());
            if ("PAID".equals(paymentStatus)) {
                payment.setPaymentDate(LocalDate.now()); // Cập nhật ngày thanh toán
            }
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment not found");
        }
    }

    @Override
    public void calculateInstallmentAmount(Payment payment) {
        if (payment.getInstallmentNumber() != null && payment.getInstallmentNumber() > 0) {
            BigDecimal installmentAmount = payment.getAmount()
                    .divide(new BigDecimal(payment.getInstallmentNumber()), RoundingMode.HALF_UP);
            payment.setInstallmentAmount(installmentAmount);
        } else {
            throw new RuntimeException("Invalid installment number");
        }
    }
}

