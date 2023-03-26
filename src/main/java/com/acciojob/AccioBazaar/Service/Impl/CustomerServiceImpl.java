package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.CustomerConvertor;
import com.acciojob.AccioBazaar.Model.Cart;
import com.acciojob.AccioBazaar.Model.Customer;
import com.acciojob.AccioBazaar.Repository.CustomerRepository;
import com.acciojob.AccioBazaar.RequestDTO.CustomerRequestDto;
import com.acciojob.AccioBazaar.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = CustomerConvertor.customerRequestDtoToCustomer(customerRequestDto);

        //allocate cart to customer
        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        //set cart in customer
        customer.setCart(cart);

        customerRepository.save(customer);
        return "Congrats..! Welcome to AccioBazaar";
    }
}
