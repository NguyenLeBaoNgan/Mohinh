package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TheLoai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtheloai;

    private String tentheloai;

    @OneToMany(mappedBy = "theloai", cascade = CascadeType.ALL)
    private List<Product> products;
}
