package com.acciojob.AccioBazaar.ResponseDTO;

import com.acciojob.AccioBazaar.Enum.ProductCategory;
import com.acciojob.AccioBazaar.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private String productName;
    private int price;
    private ProductCategory productCategory;
    private ProductStatus productStatus;
}
