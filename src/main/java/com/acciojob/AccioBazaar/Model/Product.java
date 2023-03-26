package com.acciojob.AccioBazaar.Model;

import com.acciojob.AccioBazaar.Enum.ProductCategory;
import com.acciojob.AccioBazaar.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn
    Seller seller;

   @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    Item item;

}
