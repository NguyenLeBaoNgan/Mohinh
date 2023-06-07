package com.example.Mohinh.repository;

import com.example.Mohinh.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //List<Product> findByCategoryId(Long idtheloai);

}
