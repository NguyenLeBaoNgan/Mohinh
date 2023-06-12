package com.example.Mohinh.service;

import com.example.Mohinh.entities.DonHang;
import com.example.Mohinh.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonHangService {
    @Autowired
    private DonHangRepository donHangRepository;
    public List<DonHang> getAllDH(){return donHangRepository.findAll();}
    public DonHang getDonHangById(Long iddon){return donHangRepository.findById(iddon).orElse(null);}
    public DonHang saveDonHang(DonHang donHang){return donHangRepository.save(donHang);}
    public void deteleDonHang(Long iddon){donHangRepository.deleteById(iddon);}
}
