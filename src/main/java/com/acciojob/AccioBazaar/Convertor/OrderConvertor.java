package com.acciojob.AccioBazaar.Convertor;

import com.acciojob.AccioBazaar.Model.Item;
import com.acciojob.AccioBazaar.ResponseDTO.OrderResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderConvertor {

    public static OrderResponseDto orderToOrderResponseDto(Item item){
        return OrderResponseDto.builder()
                .productName(item.getProduct().getProductName())
                .orderDate(item.getOrdered().getOrderDate())
                .quantityOrder(item.getRequiredQuantity())
                .cardUsedForPayment(item.getOrdered().getCardUsedForPayment())
                .itemPrice(item.getProduct().getPrice())
                .totalCost(item.getOrdered().getTotalCost())
                .build();
    }
}
