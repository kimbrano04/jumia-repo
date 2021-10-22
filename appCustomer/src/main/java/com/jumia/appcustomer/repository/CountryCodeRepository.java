package com.jumia.appcustomer.repository;

import com.jumia.appcustomer.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryCodeRepository extends JpaRepository<Country, Long> {
}
