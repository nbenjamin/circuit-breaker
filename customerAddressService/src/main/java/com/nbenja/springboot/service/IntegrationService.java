package com.nbenja.springboot.service;

import com.nbenja.springboot.domain.Address;
import com.nbenja.springboot.domain.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCustomerOnFallback")
    public Customer getCustomer(Long customerId) {
        ParameterizedTypeReference<Customer> customerPtr = new ParameterizedTypeReference<Customer>() {
        };
        ResponseEntity<Customer> customerResponseEntity = restTemplate.exchange("http://localhost:8091/demo/customers/" + customerId, HttpMethod.GET, null, customerPtr);
        return customerResponseEntity.getBody();
    }

    private Customer getCustomerOnFallback(Long customerId) {
        return new Customer();
    }

    @HystrixCommand(fallbackMethod = "getAddressOnFallback")
    public Address getAddress(Long customerId) {
        ParameterizedTypeReference<Address> addressPtr = new ParameterizedTypeReference<Address>() {
        };
        ResponseEntity<Address> addressResponseEntity = restTemplate.exchange("http://localhost:8092/demo/address/" + customerId, HttpMethod.GET, null, addressPtr);
        return addressResponseEntity.getBody();
    }

    public Address getAddressOnFallback(Long customerId) {
        return new Address();
    }
}
