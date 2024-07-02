package com.app.eoeats.service.mapper;

import com.app.eoeats.model.AmountExtra;
import com.app.eoeats.model.Extra;
import com.app.eoeats.model.dto.AmountExtraDto;
import com.app.eoeats.service.ExtraService;
import com.app.eoeats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmountExtraMapper {

    @Autowired
    private Utils utils;

    @Autowired
    private ExtraService extraService;


    public List<AmountExtra> listDtoToEntity(final List<AmountExtraDto> amountExtraDtos) {
        List<AmountExtra> amountExtras = new ArrayList<>();
        for (AmountExtraDto amountExtraDto : amountExtraDtos) {
            AmountExtra amountExtra = new AmountExtra();
            final Extra extra = extraService.findExtraById(amountExtraDto.getExtraId());
            amountExtra.setExtra(extra);
            amountExtras.add(amountExtra);
        }
        return amountExtras;
    }


}
