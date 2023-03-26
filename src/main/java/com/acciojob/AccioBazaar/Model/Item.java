package com.acciojob.AccioBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int requiredQuantity;

    @ManyToOne
    @JoinColumn
    Cart cart;

    @OneToOne
    @JoinColumn
    Product product;

    @ManyToOne
    @JoinColumn
    Ordered ordered;

}
