package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "DonHang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddon;

    private Integer sldon;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @ManyToMany
    @JoinTable(name = "DonHang_Product", joinColumns = @JoinColumn(name = "iddon"), inverseJoinColumns = @JoinColumn(name = "idsp"))
    private List<Product> products;

    private Double Tongtien;
}
