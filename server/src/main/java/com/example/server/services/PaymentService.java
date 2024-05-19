package com.example.server.services;

import com.example.server.dtos.PaymentDTO;
import com.example.server.entities.PaymentEntity;
import com.example.server.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.getAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO getPaymentById(Long id) {
        PaymentEntity entity = paymentRepository.getById(id);
        return entity != null ? convertToDTO(entity) : null;
    }

    public PaymentDTO getPaymentByAppointmentId(Long id) {
        PaymentEntity entity = paymentRepository.getByAppointmentId(id);
        return entity != null ? convertToDTO(entity) : null;
    }

    public PaymentEntity create(PaymentDTO paymentDTO, Long appointmentId){
        PaymentEntity paymentEntity = new PaymentEntity(
                paymentRepository.getSize(),
                paymentDTO.getAmount(),
                paymentDTO.getCurrency(),
                paymentDTO.getSenderName(),
                paymentDTO.getReceiverName(),
                appointmentId
        );
        paymentRepository.create(paymentEntity);
        return paymentEntity;
    }

    public void delete(Long id){
        paymentRepository.delete(id);
    }

    private PaymentDTO convertToDTO(PaymentEntity paymentEntity) {
        return new PaymentDTO(
                paymentEntity.getAmount(),
                paymentEntity.getCurrency(),
                paymentEntity.getSenderName(),
                paymentEntity.getReceiverName(),
                paymentEntity.getAppointmentId()
        );
    }
}
