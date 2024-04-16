package com.example.server.services;

import com.example.server.dtos.PaymentDTO;
import com.example.server.entities.PaymentEntity;
import com.example.server.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentEntity create(PaymentDTO paymentDTO){
        PaymentEntity paymentEntity = new PaymentEntity(paymentRepository.getSize(),
                paymentDTO.getAmount(), paymentDTO.getCurrency(), paymentDTO.getSenderName(), paymentDTO.getReceiverName());
        paymentRepository.create(paymentEntity);
        return paymentEntity;
    }

    public void delete(Long id){
        paymentRepository.delete(id);
    }
}
