package com.example.Mohinh.service;

import com.example.Mohinh.entities.TheLoai;
import com.example.Mohinh.repository.TheLoaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheLoaiService {
    @Autowired
    private TheLoaiRepository theLoaiRepository;
    public List<TheLoai> getAllTL(){return theLoaiRepository.findAll();}
    public TheLoai getTheLoaiById(Long idtheloai){return theLoaiRepository.findById(idtheloai).orElse(null);}
    public TheLoai saveTheLoai(TheLoai theLoai){return theLoaiRepository.save(theLoai);}
    public void deteleTheLoai(Long idtheloai){theLoaiRepository.deleteById(idtheloai);}


}
