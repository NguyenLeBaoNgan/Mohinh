package com.example.Mohinh.service;

import com.example.Mohinh.entities.Giamgia;
import com.example.Mohinh.repository.GiamGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiamGiaService {
    @Autowired
    private GiamGiaRepository giamGiaRepository;
    public List<Giamgia> getAllGiamgia(){return giamGiaRepository.findAll();}
    public Giamgia getGiamgiaById(Long idgiamgia){return giamGiaRepository.findById(idgiamgia).orElse(null);}
    public Giamgia saveGiamgia(Giamgia giamgia){return giamGiaRepository.save(giamgia);}
    public void deleteGiamGia(Long idgiamgia){giamGiaRepository.deleteById(idgiamgia);}
}
