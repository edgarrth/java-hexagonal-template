package com.poc.microservice.demo.adapters.out.mysql.springdata.repository;

import com.poc.microservice.demo.adapters.out.mysql.springdata.entity.PaymentMySQLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMySQLRepository extends JpaRepository<PaymentMySQLEntity, Long> {

    /*
    @Query(value = "Select p from PaymentMySQLEntity p")
    List<PaymentMySQLEntity> getAll();
    */

}
