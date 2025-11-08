package com.poc.microservice.demo.domain.payment;

import com.poc.microservice.demo.domain.base.Domain;

import java.time.LocalDateTime;

public class Payment extends Domain {
    // First Level Rules

    private String idTransaction;
    private String nombre;
    private Double monto;
    public Payment() {
        super();
    }

    public Payment(String idTransaction, String nombre, Double monto) {
        super();
        this.idTransaction = idTransaction;
        this.nombre = nombre;
        this.monto = monto;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
