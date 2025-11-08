package com.poc.microservice.demo.adapters.in.api.rest.controllers.payment;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.poc.microservice.demo.adapters.in.api.rest.commons.CustomResponse;
import com.poc.microservice.demo.adapters.in.api.rest.dtos.PaymentRequestDTO;
import com.poc.microservice.demo.adapters.in.api.rest.mappers.PaymentMapper;
import com.poc.microservice.demo.application.service.payment.PaymentService;
import com.poc.microservice.demo.domain.payment.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("payment_management")
public class PaymentControllerImpl extends BaseController implements PaymentController{

    public final PaymentService paymentService;
    public final PaymentMapper paymentMapper;

    public PaymentControllerImpl(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public ResponseEntity<CustomResponse> findAll() {
        try {
            List<Payment> payments = paymentService.getAll();
            if (!payments.isEmpty()) return ok("Payment", "FindALL", payments);
            else return ResponseEntity.noContent().build();
        }catch (Exception e){
            return internalError("Payment", "FindALL");
        }
    }

    @Override
    public ResponseEntity<CustomResponse> save(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = paymentMapper.toDomain(paymentRequestDTO);

        try {
            if (paymentService.save(payment)) return null;
            else return ResponseEntity.badRequest().build();
        }catch (Exception e){
            return internalError("Payment", "SAVE");
        }
    }
}
