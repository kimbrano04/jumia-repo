package com.jumia.appcustomer.util;

import com.jumia.appcustomer.model.CustomerValidated;
import com.jumia.appcustomer.model.CustomerValidatedDTO;

public class ConvertToDTO {
    public static CustomerValidatedDTO convertToDTO(CustomerValidated customerValidated){
        if(!customerValidated.getCustomer().getName().isBlank()){
            CustomerValidatedDTO customerValidatedDTO = new CustomerValidatedDTO();
            customerValidatedDTO.setName(customerValidated.getCustomer().getName());
            customerValidatedDTO.setPhone(customerValidated.getCustomer().getPhone());
            customerValidatedDTO.setId(customerValidated.getCustomer().getID());
            customerValidatedDTO.setCode(customerValidated.getCountry().getCode());
            customerValidatedDTO.setState(customerValidated.getState());
            customerValidatedDTO.setCountry(customerValidated.getCountry().getCountry());
            return  customerValidatedDTO;

        }else
            return new CustomerValidatedDTO();
    }
}
