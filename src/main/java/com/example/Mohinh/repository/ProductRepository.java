package com.example.Mohinh.repository;

import com.example.Mohinh.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.theloai.idtheloai = :idtheloai")
    List<Product> getProductByTheloaiId(Long idtheloai);


    @Query("""
            SELECT p FROM Product p
            WHERE p.tensp LIKE %?1%
            OR p.theloai.tentheloai LIKE %?1%
        """)
    List<Product> searchProduct(String keyword);
}
