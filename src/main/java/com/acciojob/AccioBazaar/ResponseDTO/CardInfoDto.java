package com.acciojob.AccioBazaar.ResponseDTO;

import com.acciojob.AccioBazaar.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardInfoDto {

    //private String name;
    private CardType cardType;
    private String cardNo;
}
