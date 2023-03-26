package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.CardConvertor;
import com.acciojob.AccioBazaar.Exception.CustomerNotFoundException;
import com.acciojob.AccioBazaar.Model.Card;
import com.acciojob.AccioBazaar.Model.Customer;
import com.acciojob.AccioBazaar.Repository.CustomerRepository;
import com.acciojob.AccioBazaar.RequestDTO.CardRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardInfoDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardResponseDto;
import com.acciojob.AccioBazaar.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer;
         try {
             customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
         }catch(Exception e){
             throw new CustomerNotFoundException("Invalid Customer Id");
         }

         //Make a card object
        Card card = CardConvertor.cardRequestDtoToCard(cardRequestDto);
         card.setCustomer(customer);

         //add card to current card list
        customer.getCardList().add(card);

        //save customer and card
        customerRepository.save(customer);

        //prepare response
        CardResponseDto cardResponseDto = CardConvertor.CardToCardResponseDto(card);
        //convert every card to cardInfoDto
        List<CardInfoDto> cardInfoDtoList = new ArrayList<>();
        for(Card card1 : customer.getCardList()){
            CardInfoDto cardInfoDto = CardConvertor.CardToCardInfoDto(card1);
            cardInfoDtoList.add(cardInfoDto);
        }
        cardResponseDto.setCardInfoDtoList(cardInfoDtoList);

        return cardResponseDto;
    }
}
