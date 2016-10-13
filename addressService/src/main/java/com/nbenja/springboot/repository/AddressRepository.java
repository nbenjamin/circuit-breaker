package com.nbenja.springboot.repository;

import com.nbenja.springboot.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class AddressRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Address findByCustomerId(Long customerId) {
        return jdbcTemplate.queryForObject("select * from Address where customerId ="+customerId, (rs, rowNum) -> {
            return new Address(rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("country"), rs.getLong("customerId"));
        });
    }

    public void save(Address address) {
        jdbcTemplate.update("INSERT INTO Address (street, city ,state ,country, customerId) values (?,?,?,?,?)",
                new Object[] {address.getStreet(), address.getCity(), address.getState(), address.getCountry(), address.getCustomerId()});
    }

    public Collection<Address> findAll() {
        return jdbcTemplate.query("select * from Address", (rs, rowNum) -> {
            return new Address(rs.getString("street"), rs.getString("city"), rs.getString("state"), rs.getString("country"), rs.getLong("customerId"));
        });
    }

}
