package com.example.agriculture.controller;

import com.example.agriculture.model.client;
import com.example.agriculture.model.commande;
import com.example.agriculture.model.region;
import com.example.agriculture.model.utilisateur;
import com.example.agriculture.service.clientService;
import com.example.agriculture.service.regionService;
import com.example.agriculture.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/region")
@RestController
public class regionController {


    @Autowired
    regionService regionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<region> listregion(){
        List<region> us = regionService.getallregion();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveregion(@RequestBody region r){

        regionService.save(r);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/region/save");

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public region findregion(@PathVariable("id") long id){

        region u= regionService.findbyid(id);
        if(u.equals(null)){
            System.out.println("Cet reg nexiste pas ");
        }
        return u;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        regionService.deleteregion(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public region updateregion(@PathVariable("id") long id, @RequestBody region r){

        return regionService.updateregion(id,r);

    }

}

