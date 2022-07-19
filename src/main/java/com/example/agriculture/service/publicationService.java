package com.example.agriculture.service;

import com.example.agriculture.model.publication;
import com.example.agriculture.repository.publicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class publicationService {
    @Autowired
    publicationRepository publicationRepository;
    public List<publication> getallpublication(){
        return  publicationRepository.findAll();
    }

    public void save(publication p){
        publicationRepository.save(p);
    }
    public publication  findbyid(long id){
        return publicationRepository.findById(id).get();
    }
    public void deletepublication(long id){

        publicationRepository.deleteById(id);
    }

    public publication updatepublication(long id, publication p){
        publicationRepository.findById(id);
        p.setId_publication(id);
        publication newu=p;
        return newu;

    }
}
