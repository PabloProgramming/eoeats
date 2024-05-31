package com.app.eoeats.repository;

import com.app.eoeats.model.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AllergenRepository extends JpaRepository<Allergen, UUID> {

}

