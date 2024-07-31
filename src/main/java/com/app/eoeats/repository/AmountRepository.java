package com.app.eoeats.repository;

import com.app.eoeats.model.Amount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AmountRepository extends JpaRepository<Amount, UUID> {

    List<Amount> getAmountsByOrderId(UUID orderId);


}
