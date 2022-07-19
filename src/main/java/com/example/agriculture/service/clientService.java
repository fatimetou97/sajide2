package com.example.agriculture.service;

import com.example.agriculture.model.client;
import com.example.agriculture.model.utilisateur;
import com.example.agriculture.repository.clientRepository;
import com.example.agriculture.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientService {
    @Autowired
    clientRepository clientRepository;
    public List<client> getallclients(){
        return   clientRepository.findAll();
    }
    public void save( client u){
        clientRepository.save(u);
    }
    public  client findbyid(long id){
        return  clientRepository.findById(id).get();
    }
    public void deleteclient(long id){

        clientRepository.deleteById(id);
    }

    public client updateclient(long id,  client u){
        clientRepository.findById(id);
        u.setId_client(id);
        client newu=u;
        return newu;

    }
}
