package com.example.Mohinh.repository;

import com.example.Mohinh.entities.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepository extends JpaRepository<NSX, Long> {
}
