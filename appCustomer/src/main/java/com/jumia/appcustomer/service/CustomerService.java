package com.jumia.appcustomer.service;


import com.jumia.appcustomer.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    public Optional<Customer> getCustomer(Long code);

    public List<Customer> listCustomer();

}
