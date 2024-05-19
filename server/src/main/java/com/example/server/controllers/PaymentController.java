package com.example.server.controllers;

import com.example.server.dtos.PaymentDTO;
import com.example.server.entities.PaymentEntity;
import com.example.server.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("")
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("appointment/{id}")
    public PaymentDTO getPaymentByAppointmentId(@PathVariable("id") Long id) {
        return paymentService.getPaymentByAppointmentId(id);
    }

    @PostMapping("/{id}")
    public PaymentEntity create(@RequestBody PaymentDTO paymentDTO, @PathVariable("id") Long id){
        return paymentService.create(paymentDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        paymentService.delete(id);
    }
}
