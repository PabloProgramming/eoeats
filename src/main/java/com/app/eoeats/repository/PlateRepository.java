package com.app.eoeats.repository;

import com.app.eoeats.model.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlateRepository extends JpaRepository<Plate, UUID> {

}
