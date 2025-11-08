package com.poc.microservice.demo.application.ports.in.payment;

import com.poc.microservice.demo.application.exceptions.ApplicationException;
import com.poc.microservice.demo.domain.payment.Payment;

import java.util.List;

@FunctionalInterface
public interface PaymentGetAllUseCase {
    List<Payment> getAll() throws ApplicationException;
}
