package com.acciojob.AccioBazaar.Repository;

import com.acciojob.AccioBazaar.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
