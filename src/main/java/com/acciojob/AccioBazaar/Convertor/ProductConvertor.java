package com.acciojob.AccioBazaar.Convertor;

import com.acciojob.AccioBazaar.Enum.ProductStatus;
import com.acciojob.AccioBazaar.Model.Product;
import com.acciojob.AccioBazaar.RequestDTO.ProductRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.ProductResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductConvertor {
    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){
        return Product.builder()
                .productName(productRequestDto.getProductName())
                .price(productRequestDto.getPrice())
                .quantity(productRequestDto.getQuantity())
                .productCategory(productRequestDto.getProductCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto productToProductResponseDto(Product product){
        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productStatus(product.getProductStatus())
                .build();
    }
}
