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

    public List<Allergen> findAllergensById(final List<String> IdsString){
        List<UUID> IdsUuid = new ArrayList<>();
        for (String id: IdsString){
            UUID uuid = UUID.fromString(id);
            IdsUuid.add(uuid);
        }
        return allergenRepository.findAllById(IdsUuid);
    }
}
