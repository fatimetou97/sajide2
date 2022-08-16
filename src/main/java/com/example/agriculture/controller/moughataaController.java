package com.example.agriculture.controller;

import com.example.agriculture.model.moughataa;
import com.example.agriculture.model.produit;
import com.example.agriculture.service.moughataaService;
import com.example.agriculture.service.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class moughataaController {
    @Autowired
   private moughataaService moughataaService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<moughataa> listmoughataa(){
        List<moughataa> lm =moughataaService.getallMoughataa();
        return lm;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity savem(@RequestBody moughataa m){

        moughataaService.save(m);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/moughataa/save");

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public  moughataa findmoughataa(@PathVariable("id") long id){

      moughataa m= moughataaService.findbyid(id);
        if(m.equals(null)){
            System.out.println("Cet moughataa nexiste pas ");
        }
        return m;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        moughataaService.deletemoghata(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public moughataa updatem(@PathVariable("id") long id, @RequestBody moughataa m){

        return moughataaService.updateM(id,m);

    }

}
