package com.app.eoeats.repository;

import com.app.eoeats.model.Extra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExtraRepository extends JpaRepository<Extra, UUID> {

}

