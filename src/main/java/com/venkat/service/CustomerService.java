package com.venkat.service;

import com.venkat.model.Customer;
import com.venkat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findByLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }
}
