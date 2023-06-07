package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;

    private String username;

    private String password;

    private String diachiuser;

    private String sdtuser;

    private String mail;

    @OneToMany(mappedBy = "user")
    private List<DonHang> donHangs;
}
