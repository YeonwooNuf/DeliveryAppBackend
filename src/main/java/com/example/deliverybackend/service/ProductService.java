//package com.example.deliverybackend.service;
//
//import com.example.deliverybackend.entity.MenuDao;
//import com.example.deliverybackend.entity.ProductDao;
//import com.example.deliverybackend.entity.ProductDto;
//import com.example.deliverybackend.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    public void saveProduct(ProductDto productDto) {
//        // DTO에서 엔티티로 매핑하여 저장
//        ProductDao productdao = new ProductDao();
//        productdao.setProductId(productDto.getProductId());
//        productdao.setProductName(productDto.getProductName());
//        productdao.setPrice(productDto.getPrice());
//        productdao.setQty(productDto.getQty());
//        productRepository.save(productdao);
//    }
//
//    public List<MenuDao> getAllProductIds() {
//        return productRepository.findAll().stream()
//                .map(ProductDao::getProductId)
//                .collect(Collectors.toList());
//    }
//
//    public List<ProductDao> getAllProducts() {
//        return productRepository.findAll();
//    }
//}
