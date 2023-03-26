package com.acciojob.AccioBazaar.Controller;

import com.acciojob.AccioBazaar.Enum.ProductCategory;
import com.acciojob.AccioBazaar.Exception.SellerNotFoundException;
import com.acciojob.AccioBazaar.RequestDTO.ProductRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.ProductResponseDto;
import com.acciojob.AccioBazaar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add_product")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto){
        ProductResponseDto productResponseDto;
        try {
            productResponseDto = productService.addProduct(productRequestDto);
        } catch (SellerNotFoundException e) {
            return new  ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productResponseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/category/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory")ProductCategory productCategory){
        return productService.getAllProductByCategory(productCategory);
    }
}
