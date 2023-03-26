package com.acciojob.AccioBazaar.Controller;

import com.acciojob.AccioBazaar.Repository.CustomerRepository;
import com.acciojob.AccioBazaar.RequestDTO.CustomerRequestDto;
import com.acciojob.AccioBazaar.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add_customer")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        return customerService.addCustomer(customerRequestDto);
    }

    //view all customer
    //get customer by id
    //delete customer by email
    //update customer

}
