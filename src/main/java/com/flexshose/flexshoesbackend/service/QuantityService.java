package com.flexshose.flexshoesbackend.service;

import java.util.List;

import com.flexshose.flexshoesbackend.dto.QuantityDTOv2;
import com.flexshose.flexshoesbackend.dto.QuantityDto;

public interface QuantityService {
  QuantityDto createQuantity(QuantityDto quantityDto);

  QuantityDto updateQuantity(QuantityDto quantityDto);

  List<QuantityDTOv2> getQuantityByProductId(Integer id);

  boolean deleteQuantity(Integer id);

  QuantityDTOv2 updateQuantity(Integer id, QuantityDTOv2 quantityDto);		
}
		