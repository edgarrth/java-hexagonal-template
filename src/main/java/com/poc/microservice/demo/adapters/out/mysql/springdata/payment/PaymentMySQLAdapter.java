package com.poc.microservice.demo.adapters.out.mysql.springdata.payment;


import com.poc.microservice.demo.adapters.out.mysql.springdata.entity.PaymentMySQLEntity;
import com.poc.microservice.demo.adapters.out.mysql.springdata.mappers.PaymentMapper;
import com.poc.microservice.demo.adapters.out.mysql.springdata.repository.PaymentMySQLRepository;
import com.poc.microservice.demo.application.exceptions.ApplicationException;
import com.poc.microservice.demo.application.ports.out.payment.PaymentGetAllPort;
import com.poc.microservice.demo.application.ports.out.payment.PaymentSavePort;
import com.poc.microservice.demo.domain.payment.Payment;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

public class PaymentMySQLAdapter implements PaymentGetAllPort, PaymentSavePort {

    public final PaymentMySQLRepository paymentMySQLRepository;
    public final PaymentMapper paymentMapper;

    public PaymentMySQLAdapter(PaymentMySQLRepository paymentMySQLRepository, PaymentMapper paymentMapper) {
        this.paymentMySQLRepository = paymentMySQLRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public List<Payment> getAll() throws ApplicationException {
        List<PaymentMySQLEntity> paymentMySQLEntityList = this.paymentMySQLRepository.findAll();
        if(!paymentMySQLEntityList.isEmpty()){
            return this.paymentMapper.toDomainList(paymentMySQLEntityList);
        }
        return new ArrayList<>();
    }

    @Override
    public Payment save(Payment payment) throws ApplicationException {
        PaymentMySQLEntity paymentMySQLEntity = this.paymentMapper.toEntity(payment);

        PaymentMySQLEntity returnPayment = this.paymentMySQLRepository.save(paymentMySQLEntity);
        if (isNull(returnPayment)) throw new ApplicationException() ;
        return this.paymentMapper.toDomain(returnPayment);
    }
}
