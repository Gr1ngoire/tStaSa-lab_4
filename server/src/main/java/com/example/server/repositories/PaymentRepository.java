package com.example.server.repositories;

import com.example.server.entities.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private final List<PaymentEntity> paymentEntities = new ArrayList<>();

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
