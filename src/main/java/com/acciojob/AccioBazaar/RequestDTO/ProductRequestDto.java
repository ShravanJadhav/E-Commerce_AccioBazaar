package com.acciojob.AccioBazaar.RequestDTO;

import com.acciojob.AccioBazaar.Enum.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {
    private int sellerId;
    private String productName;
    private int price;
    private int quantity;
    private ProductCategory productCategory;


}
