package com.example.agriculture.controller;

import com.example.agriculture.model.produit;
import com.example.agriculture.model.wilaya;
import com.example.agriculture.service.produitService;
import com.example.agriculture.service.wilayaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class wilayaController {
    @Autowired
    private wilayaService wilayaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<wilaya> listWilaya(){
        List<wilaya> us =wilayaService.getallWilaya();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveW(@RequestBody wilaya w){

       wilayaService.save(w);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/willaya/save");

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public wilaya findWillaya(@PathVariable("id") long id){

       wilaya w= wilayaService.findbyid(id);
        if(w.equals(null)){
            System.out.println("Cet wilaya nexiste pas ");
        }
        return w;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        wilayaService.deletewilaya(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public wilaya updatew(@PathVariable("id") long id, @RequestBody wilaya w){

        return wilayaService.updatew(id,w);

    }

}
