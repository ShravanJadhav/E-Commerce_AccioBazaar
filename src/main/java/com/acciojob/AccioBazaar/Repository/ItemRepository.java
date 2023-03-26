package com.acciojob.AccioBazaar.Repository;

import com.acciojob.AccioBazaar.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
