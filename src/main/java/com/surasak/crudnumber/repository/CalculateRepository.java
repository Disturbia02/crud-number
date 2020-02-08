package com.surasak.crudnumber.repository;

import com.surasak.crudnumber.entity.CalculateNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculateRepository extends JpaRepository<CalculateNum,Integer> {
}
