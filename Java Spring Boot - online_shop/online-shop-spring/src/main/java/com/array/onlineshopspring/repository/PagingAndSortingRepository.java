//package com.array.onlineshopspring.repository;
//
//import com.array.onlineshopspring.model.Product;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.awt.print.Pageable;
//import java.io.Serializable;
//import java.util.List;
//
//public interface PagingAndSortingRepository<T, ID extends Serializable> extends JpaRepository<Product, Integer> {
//
//    List<Product> findAll(Sort sort);
//
//    Page<Product> findAll(Pageable pageable,
//                          org.springframework.data.domain.Pageable p);
//
////    todo To access 2nd page of Product (page size: 20) use this:
////    PagingAndSortingRepository<Product, Integer> repository = // get access to Bean in DB
////    Page<Product> products = repository.findAll(new PageRequest(1, 20));
//}
