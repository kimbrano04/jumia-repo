package com.jumia.appcustomer.controller;


import com.jumia.appcustomer.exception.NoCountryCodeFoundException;
import com.jumia.appcustomer.model.Country;
import com.jumia.appcustomer.model.Customer;
import com.jumia.appcustomer.model.CustomerValidated;
import com.jumia.appcustomer.model.CustomerValidatedDTO;
import com.jumia.appcustomer.service.CountryService;
import com.jumia.appcustomer.service.CustomerService;
import com.jumia.appcustomer.service.CustomerValidatedService;
import com.jumia.appcustomer.util.ConvertToDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value ="/api/v1")
public class AppController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CountryService countryService;

    @Autowired
    CustomerValidatedService customerValidatedService;

    private Logger logger = LoggerFactory.getLogger(AppController.class);


    @GetMapping("/CustomerValidated")
    public ResponseEntity<List<CustomerValidatedDTO>> getAllValidatedCustomers(){
        logger.info("Getting all Validated Customers");
        try {
            return ResponseEntity.ok().body(
                    customerValidatedService.validateAllCustomers().stream()
                            .map(p-> ConvertToDTO.convertToDTO(p))
                            .collect(Collectors.toList())
            );
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/CustomerValidatedByCountry/{country}")
    public ResponseEntity<List<CustomerValidated>> getAllValidatedCustomersByCountry(@PathVariable String country){

        logger.info("Validating Validated Customers by Country " + country);
        try {
            return ResponseEntity.ok().body(customerValidatedService.validateAllCustomersByCountry(country));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/CustomerValidatedByState/{state}")
    public ResponseEntity<List<CustomerValidated>> getAllValidatedCustomersByState(@PathVariable String state){
        logger.info("Validating Validated Customers by state " + state);
        try {
            return ResponseEntity.ok().body(customerValidatedService.validateAllCustomersByState(state));
        }catch (NoCountryCodeFoundException e){
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        logger.info("Getting all Customers");
        if(!customerService.listCustomer().isEmpty())
             return ResponseEntity.ok().body(customerService.listCustomer());
        else
             return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllCountries")
    public ResponseEntity<List<Country>> getAllCountries(){
         logger.info("Getting all Countries");
         if(!countryService.getAllCountry().isEmpty())
             return ResponseEntity.ok().body(countryService.getAllCountry());
         else
             return ResponseEntity.noContent().build();
    }

    @GetMapping("/valide/{phone}")
    public ResponseEntity<Country> validePhone(@PathVariable String phone){
        logger.info("Validating number " + phone);
        try {
            return ResponseEntity.ok().body(countryService.validePhone(phone));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }



    @GetMapping("/get/{code}")
    public ResponseEntity<Customer> get(@PathVariable Long code){
        logger.info("Getting customer by code " + code);
        if(customerService.getCustomer(code).isPresent())
            return ResponseEntity.ok().body(customerService.getCustomer(code).get());
        else
            return ResponseEntity.noContent().build();
    }


}
