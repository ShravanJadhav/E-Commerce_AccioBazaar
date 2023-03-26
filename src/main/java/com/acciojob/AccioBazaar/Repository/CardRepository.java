package com.acciojob.AccioBazaar.Repository;

import com.acciojob.AccioBazaar.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
