package com.poc.microservice.demo.adapters.out.mysql.springdata.mappers;

import com.poc.microservice.demo.adapters.out.mysql.springdata.entity.PaymentMySQLEntity;
import com.poc.microservice.demo.domain.payment.Payment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.List;
import static java.util.Objects.isNull;

@Qualifier("PaymentMySQLMapper")
//@Component
public class PaymentMapperImpl implements PaymentMapper{

    @Override
    public Payment toDomain(PaymentMySQLEntity paymentMySQLEntity) {
        return new Payment(paymentMySQLEntity.getId().toString(), paymentMySQLEntity.getNombre(), paymentMySQLEntity.getMonto());
    }

    @Override
    public PaymentMySQLEntity toEntity(Payment payment) {
        if(isNull(payment)){
            throw new NullPointerException("Null Payment");
        }
        return new PaymentMySQLEntity(payment.getId(), payment.getNombre(), payment.getMonto());
    }

    @Override
    public List<Payment> toDomainList(List<PaymentMySQLEntity> paymentMySQLEntityList) {
        return paymentMySQLEntityList.stream().map(p-> toDomain(p)).toList();
    }
}
