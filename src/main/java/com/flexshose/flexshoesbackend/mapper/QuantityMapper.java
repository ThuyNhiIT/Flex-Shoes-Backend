package com.flexshose.flexshoesbackend.mapper;

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
//            quantity.setId(quantityDto.getId());
            quantity.setProduct(quantityDto.getProduct());
            quantity.setColor(quantityDto.getColor());
            quantity.setSize(quantityDto.getSize());
            quantity.setQuantity(quantityDto.getQuantity());
            return quantity;
        }
//    public static QuantityDto toQuantityDto(Quantity quantity) {
//        QuantityDto quantityDto = new QuantityDto();
//        quantityDto.setProductId(quantity.getProduct().getProductId());
//        quantityDto.setColorId(quantity.getColor().getColorId());
//        quantityDto.setSizeId(quantity.getSize().getSizeId());
//        quantityDto.setQuantity(quantity.getQuantity());
//        return quantityDto;
//    }
//
//    public static Quantity toQuantity(QuantityDto quantityDto) {
//        Quantity quantity = new Quantity();
//        quantity.setQuantity(quantityDto.getQuantity());
//        return quantity;
//    }
   

}
