package com.poc.microservice.demo.configuration;

import com.poc.microservice.demo.adapters.out.mysql.springdata.mappers.PaymentMapper;
import com.poc.microservice.demo.adapters.out.mysql.springdata.mappers.PaymentMapperImpl;
import com.poc.microservice.demo.adapters.out.mysql.springdata.payment.PaymentMySQLAdapter;
import com.poc.microservice.demo.adapters.out.mysql.springdata.repository.PaymentMySQLRepository;
import com.poc.microservice.demo.application.ports.out.payment.PaymentGetAllPort;
import com.poc.microservice.demo.application.ports.out.payment.PaymentSavePort;
import com.poc.microservice.demo.application.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeansConfiguration {

    @Primary
    @Bean
    @Qualifier("paymentMySQLMapper")
    PaymentMapper paymentMapper() {
        return new PaymentMapperImpl();
    }

    @Bean
    PaymentMySQLAdapter paymentMySQLAdapter(PaymentMySQLRepository paymentMySQLRepository, PaymentMapper paymentMapper){
        return new PaymentMySQLAdapter(paymentMySQLRepository, paymentMapper);
    }

    @Bean
    PaymentService paymentService(PaymentGetAllPort paymentGetAllPort, PaymentSavePort paymentSavePort){
        return new PaymentService(paymentGetAllPort, paymentSavePort);
    }
}
