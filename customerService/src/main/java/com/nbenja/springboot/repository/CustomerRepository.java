package com.nbenja.springboot.repository;


import com.nbenja.springboot.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Collection<Customer> findByFirstName(@Param("firstName") String firstName);

    Collection<Customer> findByLastName(@Param("lastName") String firstName);
}
