package com.example.customermanagement.controller;

import com.example.customermanagement.pojo.Payment;
import com.example.customermanagement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/status/{paymentStatus}")
    public ResponseEntity<List<Payment>> getPaymentsByStatus(@PathVariable String paymentStatus) {
        return ResponseEntity.ok(paymentService.getPaymentsByStatus(paymentStatus));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Payment>> getPaymentsByCustomerId(@PathVariable Integer customerId) {
        return ResponseEntity.ok(paymentService.getPaymentsByCustomerId(customerId));
    }

    @GetMapping("/status/{paymentStatus}/customer/{customerId}")
    public ResponseEntity<List<Payment>> getPaymentsByStatusAndCustomerId(
            @PathVariable String paymentStatus, @PathVariable Integer customerId) {
        return ResponseEntity.ok(paymentService.getPaymentsByStatusAndCustomerId(paymentStatus, customerId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Payment>> getPaymentsByProjectId(@PathVariable Integer projectId) {
        return ResponseEntity.ok(paymentService.getPaymentsByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }

    @PutMapping("/{paymentId}/status")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Integer paymentId, @RequestParam String status) {
        return ResponseEntity.ok(paymentService.updatePaymentStatus(paymentId, status));
    }
}

