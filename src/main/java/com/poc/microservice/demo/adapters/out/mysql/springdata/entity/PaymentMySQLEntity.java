package com.poc.microservice.demo.adapters.out.mysql.springdata.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="PaymentMySQLEntity")
@Table(name="TBL_PAYMENT")
public class PaymentMySQLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPayment")
    @Column(name="PAYMENT_ID")
    private Long id;

    @Size(min = 2, max = 50, message = "El nombre de contener como mínimo {mix} y máximo {max} caracteres")
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="MONTO")
    private Double monto;
}
