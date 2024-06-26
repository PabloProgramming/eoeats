package com.app.eoeats.service;

import com.app.eoeats.model.Allergen;
import com.app.eoeats.repository.AllergenRepository;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AllergenService {

    @Autowired
    private AllergenRepository allergenRepository;

    @Autowired
    private Utils utils;

    public List<Allergen> findAllergensById(final List<String> allergenIdStrings) {
        List<UUID> allergenIds = new ArrayList<>();
        for (String id : allergenIdStrings) {
            UUID uuid = utils.stringToUuid(id);
            allergenIds.add(uuid);
        }
        /* FUNCTIONAL PROGRAMMING STREAM METHOD
        List<UUID> IdsUuid = allergenIdStrings.stream().
                .map(UUID::fromString)
                .toList();*/
        return allergenRepository.findAllById(allergenIds);
    }
}
