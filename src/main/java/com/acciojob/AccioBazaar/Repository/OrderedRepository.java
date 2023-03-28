package com.acciojob.AccioBazaar.Repository;

import com.acciojob.AccioBazaar.Model.Ordered;
import com.acciojob.AccioBazaar.RequestDTO.OrderRequestDto;
import com.acciojob.AccioBazaar.ResponseDTO.OrderResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

}
