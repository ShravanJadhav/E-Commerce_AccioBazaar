package com.acciojob.AccioBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(unique = true)
    private String mobileNo;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
    List<Card> cardList = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade =CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<Ordered>orderedList= new ArrayList<>();

}
