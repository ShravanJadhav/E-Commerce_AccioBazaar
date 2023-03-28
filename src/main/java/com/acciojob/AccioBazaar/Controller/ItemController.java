package com.acciojob.AccioBazaar.Controller;

import com.acciojob.AccioBazaar.ResponseDTO.ItemResponseDto;
import com.acciojob.AccioBazaar.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

   @GetMapping("/view/{productId}")
    public ResponseEntity viewItem(@PathVariable("productId") int productId){
       ItemResponseDto itemResponseDto;

       try{
           itemResponseDto = itemService.viewItem(productId);
       }catch(Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(itemResponseDto, HttpStatus.ACCEPTED);
    }
}
