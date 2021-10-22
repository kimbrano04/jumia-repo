package com.jumia.appcustomer.service;

import com.jumia.appcustomer.exception.NoCountryCodeFoundException;
import com.jumia.appcustomer.model.Country;
import com.jumia.appcustomer.repository.CountryCodeRepository;
import com.jumia.appcustomer.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryCodeRepository countryCodeRepository;

    @Override
    public List<Country> getAllCountry() {
        return countryCodeRepository.findAll();
    }

    @Override
    public Country validePhone(String phone) {
        try {
            Optional<Country> countryAux = countryCodeRepository.findAll()
                    .stream().filter(country -> ValidatorUtil.validePhone(phone, country.getRegex())).findFirst();

            if (countryAux.isPresent())
                return countryAux.get();
            else
                return new Country();

        } catch (NoSuchElementException e) {
            throw new NoCountryCodeFoundException("No Country Code Found!");
        }
    }


}
