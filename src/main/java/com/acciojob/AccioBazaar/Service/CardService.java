package com.acciojob.AccioBazaar.Service;

import com.acciojob.AccioBazaar.Exception.CustomerNotFoundException;
import com.acciojob.AccioBazaar.RequestDTO.CardRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardResponseDto;

public interface CardService {
    CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;
}
