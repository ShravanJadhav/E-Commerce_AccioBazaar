package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.ProductConvertor;
import com.acciojob.AccioBazaar.Enum.ProductCategory;
import com.acciojob.AccioBazaar.Exception.SellerNotFoundException;
import com.acciojob.AccioBazaar.Model.Product;
import com.acciojob.AccioBazaar.Model.Seller;
import com.acciojob.AccioBazaar.Repository.ProductRepository;
import com.acciojob.AccioBazaar.Repository.SellerRepository;
import com.acciojob.AccioBazaar.RequestDTO.ProductRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.ProductResponseDto;
import com.acciojob.AccioBazaar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller;
        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }catch(Exception e){
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Product product = ProductConvertor.productRequestDtoToProduct(productRequestDto);

        product.setSeller(seller);

        seller.getProductList().add(product);

        //save seller and product
        sellerRepository.save(seller);

        //return response
        ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);

        return productResponseDto;
    }

    @Override
    public List<ProductResponseDto> getAllProductByCategory(ProductCategory productCategory) {
         List<Product>products = productRepository.findAllByProductCategory(productCategory);

        //prepare a list of response dto
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product : products){
           ProductResponseDto productResponseDto = ProductConvertor.productToProductResponseDto(product);
           productResponseDtos.add(productResponseDto);
        }

        return productResponseDtos;
    }
}
