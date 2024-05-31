package com.app.eoeats.service;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.repository.AllergenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AllergenService {

    @Autowired
    AllergenRepository allergenRepository;

    public List<Allergen> findAllergensById(final List<String> strings){
        List<UUID> uuids = new ArrayList<>();
        for (String id: strings){
            UUID uuid = UUID.fromString(id);
            uuids.add(uuid);
        }
        return allergenRepository.findAllById(uuids);
    }
}
