package com.jumia.appcustomer.service;

import com.jumia.appcustomer.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    public List<Country> getAllCountry();

    public Country validePhone(String phone);

}
