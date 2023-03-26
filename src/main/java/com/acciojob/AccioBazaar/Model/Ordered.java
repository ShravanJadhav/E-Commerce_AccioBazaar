package com.acciojob.AccioBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ordered")
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId;
    @CreationTimestamp
    private Date orderDate;
    private int totalCost;
    private int deliveryCharges;
    private String cardUsedForPayment;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

}
