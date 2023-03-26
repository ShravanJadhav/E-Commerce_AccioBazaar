package com.acciojob.AccioBazaar.Service.Impl;

import com.acciojob.AccioBazaar.Convertor.SellerConvertor;
import com.acciojob.AccioBazaar.Model.Seller;
import com.acciojob.AccioBazaar.Repository.SellerRepository;
import com.acciojob.AccioBazaar.RequestDTO.SellerRequestDto;
import com.acciojob.AccioBazaar.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public String addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepository.save(seller);
        return "Congrats...! Now you can sell on AccioBazaar";
    }

    //Get all sellers--> requestDTO and lits of responseDto
    //get a seller by pan card --> custom query 2nd
    //find sellers of particular age --> customer query
}
