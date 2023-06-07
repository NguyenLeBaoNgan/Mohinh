package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Giamgia")
public class Giamgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgiamgia;

    private String tengiamgia;

    @OneToMany(mappedBy = "giamgia")
    private List<Product> products;
}
