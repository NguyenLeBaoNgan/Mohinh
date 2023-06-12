package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "NSX")
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idnsx;

    private String tennsx;

    private String sdtnsx;

    private String diachinsx;

    private String mail;

    @OneToMany(mappedBy = "nsx", cascade = CascadeType.ALL)
    private List<Product> products;
}
