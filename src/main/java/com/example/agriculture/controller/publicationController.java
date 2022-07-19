package com.example.agriculture.controller;

import com.example.agriculture.model.commande;
import com.example.agriculture.model.publication;
import com.example.agriculture.service.publicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/publication")
@RestController
public class publicationController {


    @Autowired
    private publicationService publicationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<publication> listpublication(){
        List<publication> us = publicationService.getallpublication();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity savepublication(@RequestBody publication publication){

        publicationService.save(publication);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/publication/save");
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public publication findpublication(@PathVariable("id") long id){

        publication u= publicationService.findbyid(id);
        if(u.equals(null)){
            System.out.println("Cet pub nexiste pas ");
        }
        return u;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        publicationService.deletepublication(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public publication updatep(@PathVariable("id") long id, @RequestBody publication p){

        return publicationService.updatepublication(id,p);

    }

}

