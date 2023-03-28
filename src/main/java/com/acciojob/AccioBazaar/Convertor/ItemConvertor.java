package com.acciojob.AccioBazaar.Convertor;

import com.acciojob.AccioBazaar.Model.Product;
import com.acciojob.AccioBazaar.ResponseDTO.ItemResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemConvertor {
    public static ItemResponseDto itemToItemResponseDtoTo(Product product) {
        return ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .productStatus(product.getProductStatus())
                .build();
    }


}
