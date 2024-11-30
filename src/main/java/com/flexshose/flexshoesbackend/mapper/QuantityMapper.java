package com.flexshose.flexshoesbackend.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.flexshose.flexshoesbackend.dto.QuantityDto;
import com.flexshose.flexshoesbackend.entity.Quantity;

public class QuantityMapper {


        public static QuantityDto toQuantityDto(Quantity quantity) {
            QuantityDto quantityDto = new QuantityDto();
            quantityDto.setProduct(quantity.getProduct());
            quantityDto.setColor(quantity.getColor());
            quantityDto.setSize(quantity.getSize());
            quantityDto.setQuantity(quantity.getQuantity());
            return quantityDto;
        }


        public static Quantity toQuantity(QuantityDto quantityDto) {
            Quantity quantity = new Quantity();
            quantity.setProduct(quantityDto.getProduct());
            quantity.setColor(quantityDto.getColor());
            quantity.setSize(quantityDto.getSize());
            quantity.setQuantity(quantityDto.getQuantity());
            return quantity;
        }

		public static List<QuantityDto> toQuantityDtos(List<Quantity> quantities) {
            return quantities.stream().map(QuantityMapper::toQuantityDto).collect(Collectors.toList());
		}

		public static List<Quantity> toQuantities(List<QuantityDto> quantityDtos) {
			return quantityDtos.stream().map(QuantityMapper::toQuantity).collect(Collectors.toList());
		}

   

}
