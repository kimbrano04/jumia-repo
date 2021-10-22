package com.jumia.appcustomer.model;

import com.jumia.appcustomer.constants.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerValidated {

    private State state;
    private Customer customer;
    private Country country;

}
