package com.acciojob.AccioBazaar.Service;

import com.acciojob.AccioBazaar.Exception.CustomerNotFoundException;
import com.acciojob.AccioBazaar.RequestDTO.OrderRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.OrderResponseDto;

import java.util.List;

public interface CartService {
    String addToCart(OrderRequestDto orderRequestDto) throws Exception;

    List<OrderResponseDto> checkOutCart(int customerId) throws Exception;
}
