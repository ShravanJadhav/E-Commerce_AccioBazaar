package com.acciojob.AccioBazaar.Service;

import com.acciojob.AccioBazaar.Exception.ProductNotFoundException;
import com.acciojob.AccioBazaar.ResponseDTO.ItemResponseDto;

public interface ItemService {
    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException;
}
