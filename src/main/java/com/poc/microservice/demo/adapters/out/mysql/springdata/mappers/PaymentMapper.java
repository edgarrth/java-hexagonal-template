package com.poc.microservice.demo.adapters.out.mysql.springdata.mappers;

import com.poc.microservice.demo.adapters.out.mysql.springdata.entity.PaymentMySQLEntity;
import com.poc.microservice.demo.domain.payment.Payment;

import java.util.List;

public interface PaymentMapper {

    public Payment toDomain(PaymentMySQLEntity paymentMySQLEntity);

    public PaymentMySQLEntity toEntity(Payment payment);

    public List<Payment> toDomainList(List<PaymentMySQLEntity> paymentMySQLEntityList);

}
