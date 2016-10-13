package com.nbenja.springboot.web;

import com.nbenja.springboot.domain.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    private CustomerController subject;

    @Test
    public void validate_getCustomers(){
        assertThat(subject, is(notNullValue()));
        Collection<Customer> actual = subject.getCustomers();
        assertThat(actual.size(), is(2));
    }

}