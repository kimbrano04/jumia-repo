package com.jumia.appcustomer.service;

import com.jumia.appcustomer.constants.State;
import com.jumia.appcustomer.model.Country;
import com.jumia.appcustomer.model.CustomerValidated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerValidatedServiceImpl implements CustomerValidatedService {

    @Autowired
    CustomerService customerService;

    @Autowired
    CountryService countryService;

    @Override
    public List<CustomerValidated> validateAllCustomers() {
        List<CustomerValidated> customerValidateds = new ArrayList<>();

        customerService.listCustomer().forEach(customer -> {
            Country country = countryService.validePhone(customer.getPhone());
            if (!country.getCode().isBlank()) {
                customerValidateds.add(new CustomerValidated(State.VALID, customer, country));
            } else
                customerValidateds.add(new CustomerValidated(State.NO_VALID, customer, country));
        });

        return customerValidateds;
    }

    @Override
    public List<CustomerValidated> validateAllCustomersByCountry(String country) {
        return validateAllCustomers().stream().filter(v -> v.getCountry().getCountry().equalsIgnoreCase(country))
                                     .collect(Collectors.toList());
    }

    @Override
    public List<CustomerValidated> validateAllCustomersByState(String state) {
        return validateAllCustomers().stream().filter(v -> v.getState() == State.valueOf(state))
                .collect(Collectors.toList());

    }
}
