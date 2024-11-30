package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.QuantityDTOv2;
import com.flexshose.flexshoesbackend.dto.QuantityDto;
import com.flexshose.flexshoesbackend.dto.request.QuantityRequest;
import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Quantity;
import com.flexshose.flexshoesbackend.entity.Size;
import com.flexshose.flexshoesbackend.mapper.QuantityMapper;
import com.flexshose.flexshoesbackend.mapper.QuantityMapperv2;
import com.flexshose.flexshoesbackend.repository.ColorRepository;
import com.flexshose.flexshoesbackend.repository.ProductRepository;
import com.flexshose.flexshoesbackend.repository.QuantityRepository;
import com.flexshose.flexshoesbackend.repository.SizeRepository;
import com.flexshose.flexshoesbackend.service.QuantityService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class QuantityServiceImpl implements QuantityService {

	QuantityRepository quantityRepository;
	ProductRepository productRepository;
	ColorRepository colorRepository;
	SizeRepository sizeRepository;
	QuantityMapperv2 quantityMapperv2;

	@Override
	public QuantityDto createQuantity(QuantityDto quantityDto) {
		Quantity quantity = QuantityMapper.toQuantity(quantityDto);
		Quantity savedQuantity = quantityRepository.save(quantity);
		return QuantityMapper.toQuantityDto(savedQuantity);
	}

	@Override
	public QuantityDto updateQuantity(QuantityDto quantityDto) {
		Quantity quantity = QuantityMapper.toQuantity(quantityDto);
		Quantity updatedQuantity = quantityRepository.save(quantity);
		return QuantityMapper.toQuantityDto(updatedQuantity);
	}

	@Override
	public List<QuantityDTOv2> getQuantityByProductId(Integer id) {
		List<QuantityDTOv2> quantities = quantityRepository.findByProduct(productRepository.findById(id).get()).stream()
				.map(item -> quantityMapperv2.toDTO(item)).toList();
		return quantities;

	}

	@Override
	public boolean deleteQuantity(Integer id) {
		// TODO Auto-generated method stub
		try {
			quantityRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public QuantityDTOv2 updateQuantity(Integer id, QuantityDTOv2 quantityDto) {
		// TODO Auto-generated method stub
		Quantity quantity = quantityMapperv2.toEntity(quantityDto);
		quantity.setId(id);
		return quantityMapperv2.toDTO(quantityRepository.save(quantity));
	}

	@Override
	public Boolean updateQuantityAfterCheckout(List<QuantityRequest> quantityRequests) {
		try {
			for (QuantityRequest detail : quantityRequests) {
                Color color = colorRepository.findByColorName(detail.getColorName());
                Size size = sizeRepository.findBySizeName(detail.getSizeName());
                Product product = productRepository.findByProductId(detail.getProductId());
				
				Quantity quantity = quantityRepository.findByProductAndColorAndSize(
                                               product, color, size);
                quantity.setQuantity(quantity.getQuantity() - detail.getQuantity());
                quantityRepository.save(quantity);
               
			}
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
