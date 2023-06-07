package com.example.Mohinh.service;

import com.example.Mohinh.entities.Product;
import com.example.Mohinh.repository.ProductRepository;
import com.example.Mohinh.repository.TheLoaiRepnsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void updateProduct(Product product){
        productRepository.save(product);
    }
    public void removeProduct(Long idsp){
        productRepository.deleteById(idsp);
    }
    public Product getProductId(Long idsp){
        return productRepository.findById(idsp).orElse(null);
    }

//    public List<Product> getProductTL(Long idtheloai){
//
//        return productRepository.findByCategoryId(idtheloai);
//    }
}
