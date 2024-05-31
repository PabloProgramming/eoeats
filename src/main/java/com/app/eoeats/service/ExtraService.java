package com.app.eoeats.service;

import com.app.eoeats.model.Extra;
import com.app.eoeats.model.dto.ExtraDto;
import com.app.eoeats.repository.ExtraRepository;
import com.app.eoeats.service.mapper.ExtraMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ExtraService {

    @Autowired
    ExtraRepository extraRepository;

    @Autowired
    ExtraMapper extraMapper;


    public ExtraDto saveExtra(final ExtraDto extraDto){
        final Extra extra = extraMapper.requestDtoToEntity(extraDto);
        final Extra savedExtra = extraRepository.save(extra);
        return extraMapper.entityToDto(savedExtra);
    }

    @SneakyThrows
    public String deleteExtra(final String extraId){
        final Optional<Extra> optionalExtra = extraRepository.findById(UUID.fromString(extraId));
        if (optionalExtra.isPresent()){
            extraRepository.deleteById(UUID.fromString(extraId));
            return extraId;
        }
        throw new Exception();
    }

}





