package com.example.Mohinh.service;

import com.example.Mohinh.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
     List<Product> getAll();
    Product addProduct(Product product ,Long idgiamgia,Long idtheloai,Long idnsx);
    Product getProductId(Long idsp);
    void removeProduct(Long idsp);
    void updateProduct(Product product,Long idgiamgia,Long idtheloai,Long idnsx);
    Page<Product> findPaginated(int pageNo, int pageSize);
//    List<Product> getProductByTheloai(Long idtheloai);
}
