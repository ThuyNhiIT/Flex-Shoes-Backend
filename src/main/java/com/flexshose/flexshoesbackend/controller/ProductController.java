package com.flexshose.flexshoesbackend.controller;

import com.flexshose.flexshoesbackend.dto.AddProductDto;
import com.flexshose.flexshoesbackend.dto.ProductDTOv2;
import com.flexshose.flexshoesbackend.dto.ProductDto;
import com.flexshose.flexshoesbackend.dto.QuantityDTOv2;
import com.flexshose.flexshoesbackend.dto.QuantityDto;
import com.flexshose.flexshoesbackend.dto.request.QuantityRequest;
import com.flexshose.flexshoesbackend.entity.Brand;
import com.flexshose.flexshoesbackend.entity.Color;
import com.flexshose.flexshoesbackend.entity.ProductCategory;
import com.flexshose.flexshoesbackend.service.BrandService;
import com.flexshose.flexshoesbackend.service.ColorService;
import com.flexshose.flexshoesbackend.service.ProductCategoryService;
import com.flexshose.flexshoesbackend.service.ProductService;
import com.flexshose.flexshoesbackend.service.QuantityService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

	ProductService productService;
	QuantityService quantityService;
	BrandService brandService;
	ColorService colorService;
	ProductCategoryService productCategoryService;

	@PostMapping("/create")
	public ResponseEntity<AddProductDto> createProduct(@RequestBody AddProductDto addProductDto) {

		System.out.println("addProductDto: " + addProductDto);
		AddProductDto createdProduct = productService.createProductDto(addProductDto);
		// in ra giá trị đã create
		System.out.println("createdProductdfgdfgdfgdfgf: " + createdProduct);
		// lấy ra id của product vừa tạo

		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);

	}

	@PostMapping("/createQuantity")
	public ResponseEntity<QuantityDto> createQuantity(@RequestBody QuantityDto quantityDto) {
		QuantityDto createdQuantity = quantityService.createQuantity(quantityDto);
		return new ResponseEntity<>(createdQuantity, HttpStatus.CREATED);
	}
	@GetMapping("/getQuantityByProductId/{id}")
	public ResponseEntity<List<QuantityDTOv2>> getQuantityByProductId(@PathVariable Integer id) {
		List<QuantityDTOv2> quantities = quantityService.getQuantityByProductId(id);
		return new ResponseEntity<>(quantities, HttpStatus.OK);
	}
	@PutMapping("/updateQuantity")
	public ResponseEntity<QuantityDto> updateQuantity(@RequestBody QuantityDto quantityDto) {
		QuantityDto updatedQuantity = quantityService.updateQuantity(quantityDto);
		return new ResponseEntity<>(updatedQuantity, HttpStatus.OK);
	}
	 @PutMapping("/updateQuantityAfterCheckout")
		public ResponseEntity<Boolean> updateQuantityAfterCheckout(@RequestBody List<QuantityRequest> invoiceDetailDtos) {
		 Boolean result = quantityService.updateQuantityAfterCheckout(invoiceDetailDtos);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	@DeleteMapping("/deleteQuantity/{id}")
	public ResponseEntity<Boolean> deleteQuantity(@PathVariable Integer id) {
        Boolean result = quantityService.deleteQuantity(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
       }
	@PutMapping("/updateQuantity/{id}")
	public ResponseEntity<QuantityDTOv2> updateQuantity(@PathVariable Integer id, @RequestBody QuantityDTOv2 quantityDto) {
		QuantityDTOv2 updatedQuantity = quantityService.updateQuantity(id, quantityDto);
		return new ResponseEntity<>(updatedQuantity, HttpStatus.OK);
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

	@GetMapping("/findById/{id}")
	public ResponseEntity<ProductDTOv2> findById(@PathVariable Integer id) {
		ProductDTOv2 product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	@GetMapping("/getBrand")
	public ResponseEntity<List<Brand>> getAllBrands() {
		List<Brand> brands = brandService.getAllBrands();
		return new ResponseEntity<>(brands, HttpStatus.OK);
	}
	@GetMapping("/getColor")
	public ResponseEntity<List<Color>> getAllColors() {
		List<Color> colors = colorService.getAllColors();
		return new ResponseEntity<>(colors, HttpStatus.OK);
	}
	@GetMapping("/getCategory")
	public ResponseEntity<List<ProductCategory>> getAllCategory() {
		List<ProductCategory> categories = productCategoryService.getAllProductCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<ProductDTOv2> updateProduct(@RequestBody ProductDTOv2 productDTO) {
		ProductDTOv2 updatedProduct =  productService.updateProduct(productDTO);
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable Integer id) {
		Boolean result = productService.deleteProduct(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
