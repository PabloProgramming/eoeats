package com.app.eoeats.repository;

import com.app.eoeats.model.AmountExtra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AmountExtraRepository extends JpaRepository<AmountExtra, UUID> {

    List<AmountExtra> getAmountsExtraByAmountId(UUID orderId);


}
