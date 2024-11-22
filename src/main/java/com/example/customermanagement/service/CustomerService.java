package com.example.customermanagement.service;

import com.example.customermanagement.pojo.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Integer customerId);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Integer customerId,Customer customer);
    void deleteCustomer(Integer customerId);
}

