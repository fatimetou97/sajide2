package com.example.agriculture.service;

import com.example.agriculture.model.commune;
import com.example.agriculture.repository.communeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class communeService {


    @Autowired
   communeRepository communeRepository;
    public List<commune> getallCommune( ){
        return  communeRepository.findAll();
    }
    public void save(commune c){
        communeRepository.save(c);
    }
    public  commune findbyid(long id){
        return communeRepository.findById(id).get();
    }
    public void deletecommune(long id){

        communeRepository.deleteById(id);
    }

    public commune updateC(long id,  commune c){
       communeRepository.findById(id);
        c.setId(id);
      commune newu=c;
        return newu;

    }
}


