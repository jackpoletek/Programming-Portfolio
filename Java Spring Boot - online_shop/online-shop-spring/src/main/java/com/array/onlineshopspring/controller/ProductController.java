package com.array.onlineshopspring.controller;

import com.array.onlineshopspring.constants.AppConstants;
import com.array.onlineshopspring.dto.ProductDTO;
import com.array.onlineshopspring.payload.ApiResponse;
import com.array.onlineshopspring.payload.ProductResponse;
import com.array.onlineshopspring.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@ResponseBody
@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200"/*, maxAge = 3600*/)
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/new-test", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductDTO> addProductWithImages(@RequestPart("product") ProductDTO product,
                                                           @RequestPart("image") MultipartFile[] files) {
															   
        ProductDTO newProduct = productService.addProductWithImages(product, files);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @ResponseBody
    @PostMapping(value = "/new-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> addProduct(@RequestPart("product") ProductDTO product) {
        ProductDTO newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all-products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/with-pagination")
    public ResponseEntity<ProductResponse> getProductsPagSort(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

        ProductResponse response = productService.getProductsPagSort(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/by-id/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("productId") Integer productId) {
        ProductDTO product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/by-category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@PathVariable("categoryId") Integer categoryId) {
        List<ProductDTO> products = productService.getProductsByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(value = "/by-keyword/{keyword}")
    public ResponseEntity<List<ProductDTO>> getProductsByDescription(@PathVariable("keyword") String keyword) {
        List<ProductDTO> result = productService.getProductsByKeyword(keyword);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("productId") Integer productId, @Valid @RequestBody ProductDTO product) {
        ProductDTO updatedProduct = productService.updateProduct(product, productId);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productId") Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(new ApiResponse("Product deleted successfully", true), HttpStatus.OK);
    }
}
