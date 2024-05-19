package com.example.server.repositories;

import com.example.server.entities.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private final List<PaymentEntity> paymentEntities = new ArrayList<>(List.of(
            new PaymentEntity(1L, 100.0, "USD", "John Doe", "Hospital", 1L),
            new PaymentEntity(2L, 200.0, "USD", "Jane Doe", "Clinic", 2L),
            new PaymentEntity(3L, 150.0, "EUR", "Alice Smith", "Dental Care", 3L),
            new PaymentEntity(4L, 300.0, "GBP", "Bob Johnson", "Eye Care", 4L)
    ));

    public List<PaymentEntity> getAll(){
        return paymentEntities;
    }

    public PaymentEntity getById(Long id){
        return paymentEntities.stream()
                .filter(e -> e.getId()
                        .equals(id))
                .findFirst().orElse(null);
    }

    public PaymentEntity getByAppointmentId(Long appointmentId){
        return paymentEntities.stream().filter(e -> e.getAppointmentId()
                .equals(appointmentId))
                .findFirst()
                .orElse(null);
    }

    public void create(PaymentEntity entity){
        paymentEntities.add(entity);
    }

    public void delete(Long id){
        paymentEntities.removeIf(entity -> entity.getId().equals(id));
    }

    public long getSize(){
        return paymentEntities.size() + 1;
    }
}
