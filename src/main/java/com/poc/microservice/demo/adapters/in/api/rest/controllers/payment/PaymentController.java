package com.poc.microservice.demo.adapters.in.api.rest.controllers.payment;

import com.poc.microservice.demo.adapters.in.api.rest.commons.CustomResponse;
import com.poc.microservice.demo.adapters.in.api.rest.dtos.PaymentRequestDTO;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentController {

    @GetMapping("/payment")
    ResponseEntity<CustomResponse> findAll();

    @PostMapping("/payment")
    ResponseEntity<CustomResponse> save(@RequestBody PaymentRequestDTO paymentRequestDTO);

}
