package com.example.Mohinh.repository;

import com.example.Mohinh.entities.Giamgia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamGiaRepository extends JpaRepository<Giamgia, Long> {

}
