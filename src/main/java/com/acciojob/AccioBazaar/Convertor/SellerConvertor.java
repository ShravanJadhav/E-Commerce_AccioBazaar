package com.acciojob.AccioBazaar.Convertor;


import com.acciojob.AccioBazaar.Model.Seller;
import com.acciojob.AccioBazaar.RequestDTO.SellerRequestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConvertor {

    public static Seller SellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

       return Seller.builder()
                .name(sellerRequestDto.getName())
                .email(sellerRequestDto.getEmail())
                .mobileNo(sellerRequestDto.getMobileNo())
                .panNo(sellerRequestDto.getPanNo())
                .build();
    }


}
