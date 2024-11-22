package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.Customer;
import com.example.customermanagement.repository.CustomerRepository;
import com.example.customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer customerId) {

        return customerRepository.findById(customerId);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        LocalDateTime currentTime = LocalDateTime.now();
        customer.setCreatedAt(currentTime);
        customer.setUpdatedAt(currentTime);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Integer customerId, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);

        if (existingCustomer.isPresent()) {
            Customer updateCustomer = existingCustomer.get();

            updateCustomer.setFirstName(customer.getFirstName());
            updateCustomer.setLastName(customer.getLastName());
            updateCustomer.setDateOfBirth(customer.getDateOfBirth());
            updateCustomer.setGender(customer.getGender());
            updateCustomer.setPhone(customer.getPhone());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setClassificationId(customer.getClassificationId());
            updateCustomer.setUpdatedAt(LocalDateTime.now());

            return customerRepository.save(updateCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }


    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}

