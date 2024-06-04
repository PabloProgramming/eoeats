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

    public List<Allergen> findAllergensById(final List<String> allergenIdStrings){
        List<UUID> allergenIds = new ArrayList<>();
        for (String id: allergenIdStrings){
            UUID uuid = UUID.fromString(id);
            allergenIds.add(uuid);
        }
        /* FUNCTIONAL PROGRAMMING STREAM METHOD
        List<UUID> IdsUuid = allergenIdStrings.stream().
                .map(UUID::fromString)
                .toList();*/
        return allergenRepository.findAllById(allergenIds);
    }
}
