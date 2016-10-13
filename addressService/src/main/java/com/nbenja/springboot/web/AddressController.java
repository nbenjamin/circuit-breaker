package com.nbenja.springboot.web;


import com.nbenja.springboot.domain.Address;
import com.nbenja.springboot.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping( path = "/demo/address")
    public Collection<Address> getAddresses() {
        return addressRepository.findAll();
    }
}
