package com.acciojob.AccioBazaar.Controller;

import com.acciojob.AccioBazaar.RequestDTO.CardRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.CardResponseDto;
import com.acciojob.AccioBazaar.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add_card")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        CardResponseDto cardResponseDto;
       try{
           cardResponseDto = cardService.addCard(cardRequestDto);
       }catch (Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(cardResponseDto, HttpStatus.ACCEPTED);
    }

    //remove all card for a customer id
    //remove card



}
