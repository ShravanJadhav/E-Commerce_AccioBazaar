package com.acciojob.AccioBazaar.Controller;

import com.acciojob.AccioBazaar.RequestDTO.SellerRequestDto;
import com.acciojob.AccioBazaar.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add_seller")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
       return sellerService.addSeller(sellerRequestDto);
    }
}
