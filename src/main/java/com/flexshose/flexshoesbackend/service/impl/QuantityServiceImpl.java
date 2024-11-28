package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.QuantityDto;
import com.flexshose.flexshoesbackend.entity.Quantity;
import com.flexshose.flexshoesbackend.mapper.QuantityMapper;
import com.flexshose.flexshoesbackend.repository.QuantityRepository;
import com.flexshose.flexshoesbackend.service.QuantityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuantityServiceImpl implements QuantityService {

    private final QuantityRepository quantityRepository;

    @Override
    public QuantityDto createQuantity(QuantityDto quantityDto) {
        Quantity quantity = QuantityMapper.toQuantity(quantityDto);
        Quantity savedQuantity = quantityRepository.save(quantity);
        return QuantityMapper.toQuantityDto(savedQuantity);



    }
}
