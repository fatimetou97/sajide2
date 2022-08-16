package com.example.agriculture.controller;

import com.example.agriculture.model.commune;
import com.example.agriculture.model.produit;
import com.example.agriculture.service.communeService;
import com.example.agriculture.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class communeController {
    @Autowired
    private communeService communeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<commune> listcommune(){
        List<commune> us =communeService.getallCommune();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity savep(@RequestBody commune c){

        communeService.save(c);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/commune/save");

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public commune findproduit(@PathVariable("id") long id){

       commune c= communeService.findbyid(id);
        if(c.equals(null)){
            System.out.println("Cet produit nexiste pas ");
        }
        return c;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

       communeService.deletecommune(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public commune updatep(@PathVariable("id") long id, @RequestBody commune c){

        return communeService.updateC(id,c);

    }

}

