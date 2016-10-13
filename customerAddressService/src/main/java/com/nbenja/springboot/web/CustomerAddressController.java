package com.nbenja.springboot.web;

import com.nbenja.springboot.domain.CustomerDetails;
import com.nbenja.springboot.service.IntegrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableCircuitBreaker
@RestController
public class CustomerAddressController {


    @Autowired
    private IntegrationService integrationService;

    @GetMapping(path = "/demo/customeraddress/{customerId}")
    public CustomerDetails getCustomerDetails(@PathVariable(name = "customerId") Long customerId) {
        return getCustomerDetail(customerId);
    }

    private CustomerDetails getCustomerDetail(Long customerId) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomer(integrationService.getCustomer(customerId));
        customerDetails.setAddress(integrationService.getAddress(customerId));
        return customerDetails;
    }


}
