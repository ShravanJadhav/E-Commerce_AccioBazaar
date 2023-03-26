package com.acciojob.AccioBazaar.Service;

import com.acciojob.AccioBazaar.Enum.ProductCategory;
import com.acciojob.AccioBazaar.Exception.SellerNotFoundException;
import com.acciojob.AccioBazaar.RequestDTO.ProductRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;

    List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory);
}
