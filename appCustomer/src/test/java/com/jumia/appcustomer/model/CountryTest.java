package com.jumia.appcustomer.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CountryTest {
    @Test
    public void CreateNewCountryTest(){
        Country country = new Country(1L,"Angola","(244)","\\(244\\)\\ ?\\d{9}$");
        assertEquals("Angola",country.getCountry());
        assertEquals("(244)",country.getCode());

    }
}
