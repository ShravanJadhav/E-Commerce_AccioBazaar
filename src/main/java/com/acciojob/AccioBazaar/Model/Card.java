package com.acciojob.AccioBazaar.Model;

import com.acciojob.AccioBazaar.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String cardNo;
    private int cvv;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @ManyToOne
    @JoinColumn
    Customer customer;

}
