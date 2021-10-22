package com.jumia.appcustomer.model;


import com.jumia.appcustomer.model.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void CreateNewCustomerTest(){
        Customer customer = new Customer(1L,"Bruno","921006284");
        assertEquals("Bruno", customer.getName());
        assertEquals("921006284", customer.getPhone());

    }


}
