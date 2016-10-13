package com.nbenja.springboot.web;

import com.nbenja.springboot.domain.Customer;
import com.nbenja.springboot.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path = "/demo/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerRepository.findOne(id);
    }
}
