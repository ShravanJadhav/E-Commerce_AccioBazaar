package com.acciojob.AccioBazaar.Convertor;

import com.acciojob.AccioBazaar.Model.Card;
import com.acciojob.AccioBazaar.RequestDTO.CardRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardInfoDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CardConvertor {

    public static Card cardRequestDtoToCard(CardRequestDto cardRequestDto){
        return Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .build();
    }

    public static CardResponseDto CardToCardResponseDto(Card card){
        return  CardResponseDto.builder()
                .name(card.getCustomer().getName())
                .build();
    }

    public static CardInfoDto CardToCardInfoDto(Card card){
        return  CardInfoDto.builder()
                .cardType(card.getCardType())
                .cardNo(card.getCardNo())
                .build();
    }
}
