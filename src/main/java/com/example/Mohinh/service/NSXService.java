package com.example.Mohinh.service;

import com.example.Mohinh.entities.NSX;
import com.example.Mohinh.repository.NSXRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    public List<NSX> getAllNSX(){return nsxRepository.findAll();}
    public NSX getNSXById(Long idnsx){return nsxRepository.findById(idnsx).orElse(null);}
    public NSX saveNSX(NSX nsx){return nsxRepository.save(nsx);}
    public void deteleNSX(Long idnsx){nsxRepository.deleteById(idnsx);}


}
