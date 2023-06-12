package com.example.Mohinh.repository;

import com.example.Mohinh.entities.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang ,Long> {
}
