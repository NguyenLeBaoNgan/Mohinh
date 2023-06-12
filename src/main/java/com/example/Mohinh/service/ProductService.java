package com.example.Mohinh.service;

import com.example.Mohinh.entities.Giamgia;
import com.example.Mohinh.entities.NSX;
import com.example.Mohinh.entities.Product;
import com.example.Mohinh.entities.TheLoai;
import com.example.Mohinh.repository.GiamGiaRepository;
import com.example.Mohinh.repository.NSXRepository;
import com.example.Mohinh.repository.ProductRepository;
import com.example.Mohinh.repository.TheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GiamGiaRepository giamGiaRepository;
    @Autowired
    private TheLoaiRepository theLoaiRepository;
    @Autowired
    private NSXRepository nsxRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product ,Long idgiamgia,Long idtheloai,Long idnsx){
        Giamgia giamgia = giamGiaRepository.findById(idgiamgia).orElseThrow(()->new IllegalArgumentException("Invalid discount ID"));
        TheLoai theLoai = theLoaiRepository.findById(idtheloai).orElseThrow(()->new IllegalArgumentException("Invalid the loai ID"));
        NSX nsx = nsxRepository.findById(idnsx).orElseThrow(()->new IllegalArgumentException("Invalid nsx ID"));
        product.setTheloai(theLoai);
        product.setGiamgia(giamgia);
        product.setNsx(nsx);
        return productRepository.save(product);
    }
    public void updateProduct(Product product ,Long idgiamgia,Long idtheloai,Long idnsx){
        Giamgia giamgia = giamGiaRepository.findById(idgiamgia).orElseThrow(()->new IllegalArgumentException("Invalid discount ID"));
        TheLoai theLoai = theLoaiRepository.findById(idtheloai).orElseThrow(()->new IllegalArgumentException("Invalid the loai ID"));
        NSX nsx = nsxRepository.findById(idnsx).orElseThrow(()->new IllegalArgumentException("Invalid nsx ID"));
        product.setTheloai(theLoai);
        product.setGiamgia(giamgia);
        product.setNsx(nsx);
        productRepository.save(product);
    }
    public void removeProduct(Long idsp){
        productRepository.deleteById(idsp);
    }
    public Product getProductId(Long idsp){
        return productRepository.findById(idsp).orElse(null);
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.productRepository.findAll(pageable);
    }

    public List<Product> getProductByTheloai(Long idtheloai) {
        return productRepository.getProductByTheloaiId(idtheloai);
    }

    public List<Product> searchProduct(String keyword) {
        return productRepository.searchProduct(keyword);
    }
}
