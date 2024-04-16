package com.example.server.controllers;

import com.example.server.dtos.PaymentDTO;
import com.example.server.entities.PaymentEntity;
import com.example.server.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("")
    public PaymentEntity create(@RequestBody PaymentDTO paymentDTO){
        return paymentService.create(paymentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        paymentService.delete(id);
    }
}
