package com.example.agriculture.controller;

import com.example.agriculture.model.client;
import com.example.agriculture.model.region;
import com.example.agriculture.model.utilisateur;
import com.example.agriculture.service.clientService;
import com.example.agriculture.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/client")
@RestController
public class clientController {


    @Autowired
    clientService clientService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<client> listclient(){
        List<client> us = clientService.getallclients();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveclient(@RequestBody client c){

        clientService.save(c);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/client/save");


    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public client findclient(@PathVariable("id") long id){

        client u= clientService.findbyid(id);
        if(u.equals(null)){
            System.out.println("Cet client nexiste pas ");
        }
        return u;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        clientService.deleteclient(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public client updateclient(@PathVariable("id") long id, @RequestBody client c){

        return clientService.updateclient(id,c);

    }

}

