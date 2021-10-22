package com.jumia.appcustomer.service;

import com.jumia.appcustomer.model.Customer;
import com.jumia.appcustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomer(Long code) {
        return customerRepository.findById(code);
    }

    @Override
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }


}
