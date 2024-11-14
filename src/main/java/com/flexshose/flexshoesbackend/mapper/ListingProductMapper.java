package com.flexshose.flexshoesbackend.mapper;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.entity.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 *  private int productId;
 *     private String productName;
 *     private double originalPrice;
 *     private double salePrice;
 *     private double finalPrice;
 *     private String colorName;
 *     private String sizeName;
 *     private String brandName;
 *     private String categoryName;
 *     private String gender;
 *     private int quantity;
 *    // image
 *    private Set<String> images;
 */
@Slf4j
public class ListingProductMapper {
    public static ListingProductDto mapToListingProductDto(Product product, Quantity quantity, Brand brand, ProductCategory productCategory,Size size,Color color) {
        ListingProductDto listingProductDto = new ListingProductDto();
        listingProductDto.setProductId(product.getProductId());
        listingProductDto.setProductName(product.getProductName());
        listingProductDto.setOriginalPrice(product.getOriginalPrice());
        listingProductDto.setSalePrice(product.getSalePrice());
        listingProductDto.setColorName(color.getColorName());
        listingProductDto.setSizeName(size.getSizeName());
        listingProductDto.setQuantity(quantity.getQuantity());
        listingProductDto.setBrandName(brand.getBrandName());
        listingProductDto.setCategoryName(productCategory.getCategoryName());
        listingProductDto.setGender(product.getGender().toString());
        listingProductDto.setImages(product.getImages());
        double finalPrice = product.getSalePrice() * (1 + product.getVat() / 100);
        listingProductDto.setFinalPrice(finalPrice);
//        // Example of how final price might be calculated (adjust as needed)
//        double finalPrice = product.getSalePrice() * (1 + product.getVat() / 100);
//
//        // Assuming you need the first available quantity entry for setting color, size and quantity info in listing
//        Optional<Quantity> quantityOpt = product.getQuantities().stream().findAny();
//
//        if (quantityOpt.isPresent()) {
//            Quantity quantity = quantityOpt.get();
//            listingProductDto.setColorName(quantity.getColor().getColorName());
//            listingProductDto.setSizeName(quantity.getSize().getSizeName());
//            listingProductDto.setQuantity(quantity.getQuantity());
//        } else {
//            listingProductDto.setColorName("N/A");
//            listingProductDto.setSizeName("N/A");
//            listingProductDto.setQuantity(0);
//        }
//        listingProductDto.setBrandName(product.getBrand().getBrandName());
//        listingProductDto.setCategoryName(product.getProductCategory().getCategoryName());
//        listingProductDto.setGender(product.getGender().toString());
//        listingProductDto.setImages(product.getImages());
//
//        // Example of how final price might be calculated (adjust as needed)
//        double finalPrice = product.getSalePrice() * (1 + product.getVat() / 100);
//        listingProductDto.setFinalPrice(finalPrice);

        return listingProductDto;

    }
    public static Product mapToProduct(ListingProductDto listingProductDto) {
        Product product = new Product();
        product.setProductId(listingProductDto.getProductId());
        product.setProductName(listingProductDto.getProductName());
        product.setOriginalPrice(listingProductDto.getOriginalPrice());
        product.setSalePrice(listingProductDto.getSalePrice());
        product.setVat(listingProductDto.getFinalPrice() / listingProductDto.getSalePrice() - 1); // Assuming VAT calculation
        product.setGender(Gender.valueOf(listingProductDto.getGender()));
        product.setImages(listingProductDto.getImages());

        // Assuming you need to set color, size and quantity info in product
        Quantity quantity = new Quantity();
        Color color = new Color();
        color.setColorName(listingProductDto.getColorName());
        quantity.setColor(color);
        Size size = new Size();
        size.setSizeName(listingProductDto.getSizeName());
        quantity.setSize(size);
        quantity.setQuantity(listingProductDto.getQuantity());
        product.getQuantities().add(quantity);

        Brand brand = new Brand();
        brand.setBrandName(listingProductDto.getBrandName());
        product.setBrand(brand);

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName(listingProductDto.getCategoryName());
        product.setProductCategory(productCategory);

        return product;
    }

//    public static Product mapToListingProduct(ListingProductDto ListingProductDto) {
//        Product product = new Product();
//        product.setProductId(ListingProductDto.getProductId());
//        product.setProductName(ListingProductDto.getProductName());
//        product.setOriginalPrice(ListingProductDto.getOriginalPrice());
//        product.setSalePrice(ListingProductDto.getSalePrice());
//        // Assuming you need to set color, size and quantity info in product
//        Quantity quantity = new Quantity();
//        Color color = new Color();
//        color.setColorName(ListingProductDto.getColorName());
//        quantity.setColor(color);
//        Size size = new Size();
//        size.setSizeName(ListingProductDto.getSizeName());
//        quantity.setSize(size);
//        quantity.setQuantity(ListingProductDto.getQuantity());
//        product.getQuantities().add(quantity);
//
//        return product;
//    }


}
