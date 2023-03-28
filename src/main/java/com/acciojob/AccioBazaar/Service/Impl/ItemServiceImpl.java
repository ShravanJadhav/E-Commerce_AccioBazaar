package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.ItemConvertor;
import com.acciojob.AccioBazaar.Exception.ProductNotFoundException;
import com.acciojob.AccioBazaar.Model.Item;
import com.acciojob.AccioBazaar.Model.Product;
import com.acciojob.AccioBazaar.Repository.ProductRepository;
import com.acciojob.AccioBazaar.ResponseDTO.ItemResponseDto;
import com.acciojob.AccioBazaar.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try{
            product = productRepository.findById(productId).get();
        }catch(Exception e){
            throw new ProductNotFoundException("Invalid Product Id");
        }
        Item item = Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        //map item to product
        product.setItem(item);

        //save both item and product
        productRepository.save(product);

       //prepare response dto
        ItemResponseDto itemResponseDto = ItemConvertor.itemToItemResponseDtoTo(product);
        return itemResponseDto;
    }
}
