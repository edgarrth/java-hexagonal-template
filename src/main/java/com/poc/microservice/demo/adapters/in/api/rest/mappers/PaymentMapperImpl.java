package com.poc.microservice.demo.adapters.in.api.rest.mappers;

import com.poc.microservice.demo.adapters.in.api.rest.dtos.PaymentRequestDTO;
import com.poc.microservice.demo.domain.payment.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapperImpl implements PaymentMapper{

    @Override
    public Payment toDomain(PaymentRequestDTO paymentRequestDTO) {
        return new Payment(paymentRequestDTO.getIdTransaction(), paymentRequestDTO.getNombre(), paymentRequestDTO.getMonto());
    }
}
