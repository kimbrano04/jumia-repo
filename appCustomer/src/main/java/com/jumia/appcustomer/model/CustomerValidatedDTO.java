package com.jumia.appcustomer.model;

import com.jumia.appcustomer.constants.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerValidatedDTO {
    private Long id;
    private State state;
    private String name;
    private String phone;
    private String country;
    private String code;

}
