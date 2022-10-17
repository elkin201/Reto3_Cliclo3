package com.example.retos3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos3.entities.Ortopedic;
import com.example.retos3.services.OrtopedicService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Ortopedic")
public class OrtopedicController {    

    @Autowired
    OrtopedicService ortopedicService;

    public OrtopedicController(OrtopedicService ortopedicService) {
        this.ortopedicService = ortopedicService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ortopedic>> getOrtopedics(){
        return new ResponseEntity<List<Ortopedic>>(this.ortopedicService.getListOrtopedics(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ortopedic> getOrtopedic(@PathVariable("id") int id){
        return new ResponseEntity<Ortopedic>(this.ortopedicService.getOrtopedic(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearOrtopedic(@RequestBody Ortopedic ortopedic){
        System.out.println("Controller OK *************");
        this.ortopedicService.crearOrtopedic(ortopedic);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  eliminarOrtopedic(@PathVariable("id") int id){
        this.ortopedicService.eliminarOrtopedic(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>  actualizarOrtopedic(@RequestBody Ortopedic ortopedic){
        this.ortopedicService.actualizarOrtopedic(ortopedic.getId(), ortopedic);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
