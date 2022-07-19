package com.example.agriculture.service;

import com.example.agriculture.model.commande;
import com.example.agriculture.model.produit;

import com.example.agriculture.model.region;
import com.example.agriculture.model.role;
import com.example.agriculture.repository.commandeRepository;
import com.example.agriculture.repository.produitRepository;

import com.example.agriculture.repository.regionRepository;
import com.example.agriculture.repository.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class regionService {
    @Autowired
    com.example.agriculture.repository.regionRepository regionRepository;
    public List<region> getallregion(){
        return  regionRepository.findAll();
    }
    public void save(region r){
        regionRepository.save(r);
    }
    public  region findbyid(long id){
        return regionRepository.findById(id).get();
    }
    public void deleteregion(long id){

        regionRepository.deleteById(id);
    }

    public region updateregion(long id, region p){
        regionRepository.findById(id);
        p.setId_region(id);
        region newu=p;
        return newu;

    }
}
