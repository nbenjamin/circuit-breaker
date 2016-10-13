package com.nbenja.springboot.web;

import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/demo/customers")
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
