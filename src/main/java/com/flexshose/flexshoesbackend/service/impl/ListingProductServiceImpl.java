package com.flexshose.flexshoesbackend.service.impl;

import com.flexshose.flexshoesbackend.dto.ListingProductDto;
import com.flexshose.flexshoesbackend.entity.Product;
import com.flexshose.flexshoesbackend.entity.Quantity;
import com.flexshose.flexshoesbackend.repository.ListingProductRepository;
import com.flexshose.flexshoesbackend.service.ListingProductService;
import com.flexshose.flexshoesbackend.mapper.ListingProductMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ListingProductServiceImpl implements ListingProductService {

    @Autowired
    private ListingProductRepository listingProductRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ListingProductDto> filterProductsByCriteria(String[] colors, String[] sizes, String[] brands, String[] category, String[] genders, double minPrice, double maxPrice) {
        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Product p JOIN p.quantities q JOIN q.color c JOIN q.size s JOIN p.brand b JOIN p.productCategory pc WHERE q.quantity > 0 AND p.status = 'Available'");

        // Add color filter
        if (colors != null && colors.length > 0) {
            queryBuilder.append(" AND c.colorName IN :colors");
        }

        // Add size filter
        if (sizes != null && sizes.length > 0) {
            queryBuilder.append(" AND s.sizeName IN :sizes");
        }

        // Add brand filter
        if (brands != null && brands.length > 0) {
            queryBuilder.append(" AND b.brandName IN :brands");
        }

        // Normalize gender values to match enum constants
        if (genders != null && genders.length > 0) {
            genders = Arrays.stream(genders)
                            .map(String::toUpperCase) // Convert to uppercase
                            .toArray(String[]::new);
            queryBuilder.append(" AND p.gender IN :genders");
        }

        // Add category filter
        if (category != null && category.length > 0) {
            queryBuilder.append(" AND pc.categoryName IN :category");
        }

        // Add price filter
        if (minPrice >= 0 && maxPrice >= 0) {
            queryBuilder.append(" AND (CASE WHEN p.salePrice > 0 THEN (p.originalPrice - (p.originalPrice * p.salePrice / 100)) * (1 + p.vat / 100) ELSE p.originalPrice * (1 + p.vat / 100) END) BETWEEN :minPrice AND :maxPrice");
        }

        Query query = entityManager.createQuery(queryBuilder.toString(), Product.class);

        // Set parameters
        if (colors != null && colors.length > 0) {
            query.setParameter("colors", Arrays.asList(colors));
        }
        if (sizes != null && sizes.length > 0) {
            query.setParameter("sizes", Arrays.asList(sizes));
        }
        if (brands != null && brands.length > 0) {
            query.setParameter("brands", Arrays.asList(brands));
        }
        if (category != null && category.length > 0) {
            query.setParameter("category", Arrays.asList(category));
        }
        if (genders != null && genders.length > 0) {
            query.setParameter("genders", Arrays.asList(genders));
        }
        if (minPrice >= 0 && maxPrice >= 0) {
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
        }

        // Debugging output
        System.out.println("Generated Query: " + queryBuilder.toString());
        System.out.println("Parameters: ");
        System.out.println("Colors: " + Arrays.toString(colors));
        System.out.println("Sizes: " + Arrays.toString(sizes));
        System.out.println("Brands: " + Arrays.toString(brands));
        System.out.println("Categories: " + Arrays.toString(category));
        System.out.println("Genders: " + Arrays.toString(genders));
        System.out.println("Min Price: " + minPrice);
        System.out.println("Max Price: " + maxPrice);

        List<ListingProductDto> result = new ArrayList<>();
        List<Product> products = query.getResultList();

        for (Product product : products) {
            for (Quantity quantity : product.getQuantities()) {
                // Only add the product if its size matches the requested size
                if (sizes != null && sizes.length > 0 && Arrays.asList(sizes).contains(quantity.getSize().getSizeName())) {
                    ListingProductDto listingProductDto = ListingProductMapper.mapToListingProductDto(
                        product,
                        quantity,
                        product.getBrand(),
                        product.getProductCategory(),
                        quantity.getSize(),
                        quantity.getColor()
                    );
                    result.add(listingProductDto);
                }
            }
        }

        // Sort the result list based on final price after mapping
        result.sort((p1, p2) -> Double.compare(p1.getFinalPrice(), p2.getFinalPrice()));
        return result;
    }



    }
    

