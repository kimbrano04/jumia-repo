package com.jumia.appcustomer.service;

import com.jumia.appcustomer.model.CustomerValidated;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerValidatedService {

    List<CustomerValidated> validateAllCustomers();

    List<CustomerValidated> validateAllCustomersByCountry(String country);

    List<CustomerValidated> validateAllCustomersByState(String country);

}
