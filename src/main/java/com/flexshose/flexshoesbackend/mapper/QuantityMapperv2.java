package com.flexshose.flexshoesbackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flexshose.flexshoesbackend.dto.QuantityDTOv2;
import com.flexshose.flexshoesbackend.entity.Quantity;

@Mapper(componentModel = "spring")
public interface QuantityMapperv2 {
	
	@Mapping(target = "productId", source = "product.productId")
	@Mapping(target = "sizeName", source = "size.sizeName")
	@Mapping(target = "colorId", source = "color.colorId")
	@Mapping(target = "colorName", source = "color.colorName")
	@Mapping(target = "sizeId", source = "size.sizeId")
	@Mapping(target = "productName", source = "product.productName")
	@Mapping(target = "quantity", source = "quantity")
	public QuantityDTOv2 toDTO(Quantity quantity);
	
	@Mapping(target = "product.productId", source = "productId")
	@Mapping(target = "size.sizeName", source = "sizeName")
	@Mapping(target = "color.colorId", source = "colorId")
	@Mapping(target = "color.colorName", source = "colorName")
	@Mapping(target = "size.sizeId", source = "sizeId")
	@Mapping(target = "product.productName", source = "productName")
	@Mapping(target = "quantity", source = "quantity")
	public Quantity toEntity(QuantityDTOv2 quantityDTOv2);
}
