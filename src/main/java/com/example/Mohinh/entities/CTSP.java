package com.example.Mohinh.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CTSP")
public class CTSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idctsp;

    @OneToOne
    @JoinColumn(name = "idsp")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idnsx")
    private NSX nsx;

    private Integer chieucao;

    private Float trongluong;

    private String mota;
}
