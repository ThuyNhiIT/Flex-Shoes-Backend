package com.flexshose.flexshoesbackend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flexshose.flexshoesbackend.dto.ProductDTOv2;
import com.flexshose.flexshoesbackend.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapperv2 {

	@Mapping(source = "gender", target = "gender") // Enum to String
	@Mapping(source = "productCategory.categoryId", target = "categoryId")
	@Mapping(source = "productCategory.categoryName", target = "categoryName")
	@Mapping(source = "brand.brandId", target = "brandId")
	@Mapping(source = "brand.brandName", target = "brandName")
	ProductDTOv2 toDto(Product product);

	@Mapping(source = "gender", target = "gender") // String to Enum
	@Mapping(source = "categoryId", target = "productCategory.categoryId")
	@Mapping(source = "categoryName", target = "productCategory.categoryName")
	@Mapping(source = "brandId", target = "brand.brandId")
	@Mapping(source = "brandName", target = "brand.brandName")
	Product toEntity(ProductDTOv2 productDTO);

	List<ProductDTOv2> toDtoList(List<Product> products);

	List<Product> toEntityList(List<ProductDTOv2> productDTOs);

}
