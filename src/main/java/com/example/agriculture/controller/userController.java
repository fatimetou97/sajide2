package com.example.agriculture.controller;

import com.example.agriculture.model.region;
import com.example.agriculture.model.utilisateur;
import com.example.agriculture.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RequestMapping("/user")
@RestController
public class userController {


    @Autowired
    private userService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<utilisateur> listuser(){
        List<utilisateur> us = userService.getallusers();
        return us;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveuser(@RequestBody utilisateur c){

        userService.save(c);
        return  ResponseEntity.status(HttpStatus.CREATED).body("/user/save");

    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public utilisateur finduser(@PathVariable("id") long id){

        utilisateur u= userService.findbyid(id);
        if(u.equals(null)){
            System.out.println("Cet u nexiste pas ");
        }
        return u;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") long id){

        userService.deleteuser(id);
        return "La suppresion avec success!";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public utilisateur updateuser(@PathVariable("id") long id, @RequestBody utilisateur u){

        return userService.updateuser(id,u);

    }

}

