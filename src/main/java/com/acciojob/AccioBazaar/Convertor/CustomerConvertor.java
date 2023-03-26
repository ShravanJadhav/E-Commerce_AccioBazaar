package com.acciojob.AccioBazaar.Convertor;

import com.acciojob.AccioBazaar.Model.Customer;
import com.acciojob.AccioBazaar.RequestDTO.CustomerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConvertor {
    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .email(customerRequestDto.getEmail())
                .mobileNo(customerRequestDto.getMobileNo())
                .build();
    }
}
