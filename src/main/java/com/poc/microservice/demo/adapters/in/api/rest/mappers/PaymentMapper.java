package com.poc.microservice.demo.adapters.in.api.rest.mappers;

import com.poc.microservice.demo.adapters.in.api.rest.dtos.PaymentRequestDTO;
import com.poc.microservice.demo.domain.payment.Payment;

public interface PaymentMapper {

    Payment toDomain(PaymentRequestDTO paymentRequestDTO);

}
