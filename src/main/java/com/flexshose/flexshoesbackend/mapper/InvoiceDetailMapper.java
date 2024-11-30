	package com.flexshose.flexshoesbackend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.flexshose.flexshoesbackend.dto.InvoiceDetailDto;
import com.flexshose.flexshoesbackend.entity.InvoiceDetail;
import com.flexshose.flexshoesbackend.entity.Product;

@Mapper(componentModel = "spring", uses = {ProductMapperv2.class})
public interface InvoiceDetailMapper {
	
	 	@Mapping(target = "product", source = "productId", qualifiedByName = "mapProductIdToProduct")
	 	@Mapping(target = "invoice.invoiceId", source = "invoiceId")
	    InvoiceDetail toEntity(InvoiceDetailDto detailDTO);
	 	
	    @Mapping(target = "productId", source = "product.productId")
	    @Mapping(target = "invoiceId", source = "invoice.invoiceId")
	    @Mapping(target = "productName", source = "product.productName")
	    @Mapping(target = "originalPrice", source = "product.originalPrice")
	    @Mapping(target = "salePrice", source = "product.salePrice")
	    InvoiceDetailDto toDTO(InvoiceDetail detail);

	    List<InvoiceDetail> toEntities(List<InvoiceDetailDto> detailDTOs);

	    List<InvoiceDetailDto> toDTOs(List<InvoiceDetail> details);

	    @Named("mapProductIdToProduct")
	    static Product mapProductIdToProduct(Integer productId) {
	        Product product = new Product();
	        product.setProductId(productId);
	        return product;
	    }

}
