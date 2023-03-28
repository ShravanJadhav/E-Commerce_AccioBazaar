package com.acciojob.AccioBazaar.Service;

import com.acciojob.AccioBazaar.Exception.CustomerNotFoundException;
import com.acciojob.AccioBazaar.Exception.ProductNotFoundException;
import com.acciojob.AccioBazaar.RequestDTO.OrderRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.OrderResponseDto;

public interface OrderService {

    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}
