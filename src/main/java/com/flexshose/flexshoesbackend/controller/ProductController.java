package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.AddProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.dto.QuantityDto;
import com.flexshose.flexshoesbackend.service.ProductService;
import com.flexshose.flexshoesbackend.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    private final ProductService productService;
    private final QuantityService quantityService;

    @Autowired
    public ProductController(ProductService productService, QuantityService quantityService) {
        this.productService = productService;
        this.quantityService = quantityService;
    }

    @PostMapping("/create")
    public ResponseEntity<AddProductDto> createProduct(@RequestBody AddProductDto addProductDto) {

        System.out.println("addProductDto: " + addProductDto);
       AddProductDto createdProduct = productService.createProductDto(addProductDto);
       //in ra giá trị đã create
        System.out.println("createdProductdfgdfgdfgdfgf: " + createdProduct);
        // lấy ra id của product vừa tạo

         return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }
    @PostMapping("/createQuantity")
    public ResponseEntity<QuantityDto> createQuantity(@RequestBody QuantityDto quantityDto) {
//        System.out.println("quantityDto: " + quantityDto);
//
//        return new ResponseEntity<>(quantityDto, HttpStatus.CREATED);
        QuantityDto createdQuantity = quantityService.createQuantity(quantityDto);
//        System.out.println("createdQuantity: " + createdQuantity);
        return new ResponseEntity<>(createdQuantity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProductsByName(@RequestParam String name) {
        List<ProductDto> products = productService.searchProductsByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
