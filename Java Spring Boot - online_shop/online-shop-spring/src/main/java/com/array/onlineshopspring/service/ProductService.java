package com.array.onlineshopspring.service;

import com.array.onlineshopspring.dto.ProductDTO;
import com.array.onlineshopspring.payload.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductDTO addProductWithImages(ProductDTO productDTO, MultipartFile[] files);
    ProductDTO addProduct(ProductDTO productDTO);
    ProductResponse getProductsPagSort(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Integer productId);
    List<ProductDTO> getProductsByCategoryId(Integer categoryId);
    List<ProductDTO> getProductsByKeyword(String keyword);
    ProductDTO updateProduct(ProductDTO product, Integer productId);
    void deleteProduct(Integer productId);
}
