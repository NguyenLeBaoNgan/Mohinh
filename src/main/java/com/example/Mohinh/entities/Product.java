package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsp;

    private String tensp;

    private Double price;

    private Integer soluong;

    private String image;

    @ManyToOne
    @JoinColumn(name = "idgiamgia")
    private Giamgia giamgia;

    @ManyToOne
    @JoinColumn(name = "idtheloai")
    private TheLoai theloai;

    @ManyToMany(mappedBy = "products")
    private List<DonHang> donHangs;

    @ManyToOne
    @JoinColumn(name = "idnsx")
    private NSX nsx;

    private Integer chieucao;

    private Float trongluong;

    private String mota;
}
