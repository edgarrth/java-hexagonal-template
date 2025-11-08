package com.poc.microservice.demo.adapters.in.api.rest.dtos;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String idTransaction;
    private String nombre;
    private Double monto;

}
