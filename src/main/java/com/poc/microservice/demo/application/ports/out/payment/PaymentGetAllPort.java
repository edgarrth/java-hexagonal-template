package com.poc.microservice.demo.application.ports.out.payment;

import com.poc.microservice.demo.application.exceptions.ApplicationException;
import com.poc.microservice.demo.domain.payment.Payment;

import java.util.List;

@FunctionalInterface
public interface PaymentGetAllPort {

    List<Payment> getAll() throws ApplicationException;
}
