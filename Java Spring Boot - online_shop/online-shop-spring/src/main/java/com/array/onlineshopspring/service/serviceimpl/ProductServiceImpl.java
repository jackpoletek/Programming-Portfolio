package com.array.onlineshopspring.service.serviceimpl;

import com.array.onlineshopspring.dto.ProductDTO;
import com.array.onlineshopspring.exception.ResourceNotFoundException;
import com.array.onlineshopspring.model.Category;
import com.array.onlineshopspring.model.Image;
import com.array.onlineshopspring.model.Product;
import com.array.onlineshopspring.payload.ProductResponse;
import com.array.onlineshopspring.repository.CategoryRepository;
import com.array.onlineshopspring.repository.ProductRepository;
import com.array.onlineshopspring.service.ProductService;
import com.array.onlineshopspring.util.PatternMatcher;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    private List<Image> uploadImage(MultipartFile[] files) throws IOException {
        List<Image> images = new ArrayList<>();

        for (MultipartFile file : files) {
            Image image = new Image(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            images.add(image);
        }
        return images;
    }
    @Override
    public ProductDTO addProductWithImages(ProductDTO productDTO, MultipartFile[] files) {

        Product product = Optional.ofNullable(productDTO.getProductId())
                .flatMap(productRepository::findById)
                .orElse(null);

        if (product == null) {
            product = new Product();
        }

        try {
            List<Image> images = uploadImage(files);
            product.setImageList(images);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        product.setProductDescription(productDTO.getProductDescription());
        product.setSpecies(productDTO.getSpecies());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        setCategory(product);

        productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {

        Product product = Optional.ofNullable(productDTO.getProductId())
                .flatMap(productRepository::findById)
                .orElse(null);

        if (product == null) {
            product = new Product();
        }

        product.setProductDescription(productDTO.getProductDescription());
        product.setSpecies(productDTO.getSpecies());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        setCategory(product);

        productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public ProductResponse getProductsPagSort(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = sortBy(sortBy, sortDir);

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> pageProducts = productRepository.findAll(pageable);

        List<Product> allProducts = pageProducts.getContent();
//        List<Product> allProducts = productRepository.findAll();

        List<ProductDTO> products = allProducts.stream()
                .map(it -> modelMapper.map(it, ProductDTO.class)).toList();

        ProductResponse productResponse = new ProductResponse();
        productResponse.setContent(products);
        productResponse.setPageNumber(pageProducts.getNumber());
        productResponse.setPageSize(pageProducts.getSize());
        productResponse.setTotalElements(pageProducts.getTotalElements());
        productResponse.setTotalPages(pageProducts.getTotalPages());
        productResponse.setLastPage(productResponse.isLastPage());

        return productResponse;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDTO> products = allProducts.stream()
                .map(it -> modelMapper.map(it, ProductDTO.class)).collect(Collectors.toList());

        return products;
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "id", productId));

        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(Integer categoryId) {

        List<Product> products = productRepository.findAll();

        List<ProductDTO> matchingProducts = products.stream()
                .filter(it -> Objects.equals(it.getCategory().getCategoryId(), categoryId))
                .map(it -> modelMapper.map(it, ProductDTO.class))
                .toList();

        return matchingProducts;
    }

    @Override
    public List<ProductDTO> getProductsByKeyword(String keyword) {
//        Optional<List<Product>> productsDb = productRepository.findByDescriptionContaining(keyword);
//        List<ProductDTO> products = productsDb.stream()
//                .map(it -> modelMapper.map(it, ProductDTO.class)).collect(Collectors.toList());

        List<Product> productsDb = productRepository.findByDescriptionContaining("%"+keyword+"%");

        List<ProductDTO> products = productsDb.stream()
                .map(it -> modelMapper.map(it, ProductDTO.class)).toList();

        return products;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Integer productId) {

        Product product = Optional.ofNullable(productDTO.getProductId())
                .flatMap(productRepository::findById)
                .orElse(null);

        Product updatedProduct = new Product();

        if (product != null) {
            product.setSpecies(productDTO.getSpecies());
            product.setProductDescription(productDTO.getProductDescription());
            product.setStock(productDTO.getStock());
            product.setPrice(productDTO.getPrice());
            updatedProduct = productRepository.save(product);
        } else {
            System.out.println("No product found");
        }

        return modelMapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product", "id", productId));

        productRepository.delete(product);
    }
	
    private void setCategory(Product product) {
        List<Category> categoryList = categoryRepository.findAll();

        // This works -> CategoryDescription is added automatically (DO NOT ENTER on frontend)
        Category cat = categoryList.stream()
                .filter(it ->
                        PatternMatcher.matchDescription(it.getCategoryDescription(), product.getProductDescription()))
                .map(Category.class::cast)
                .findFirst()
                .orElse(null);

        product.setCategory(cat);
    }
	
    private Sort sortBy(String sortBy, String sortDir) {

        return sortDir.equalsIgnoreCase("asc")? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
//        Sort sort;
//        if (sortDir.equalsIgnoreCase("asc")) {
//            sort = Sort.by(sortBy).ascending();
//        } else {
//            sort = Sort.by(sortBy).descending();
//        }
//        return sort;
    }
}
