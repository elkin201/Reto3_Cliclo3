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

import com.example.retos3.entities.Client;
import com.example.retos3.services.ClientService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Client")
public class ClientController {    

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClients(){
        return new ResponseEntity<List<Client>>(this.clientService.getListClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int id){
        return new ResponseEntity<Client>(this.clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearClient(@RequestBody Client client){
        this.clientService.crearClient(client);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClient(@PathVariable("id") int id){
        this.clientService.eliminarClient(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarClient(@RequestBody Client client){
        this.clientService.actualizarClient(client.getIdClient(), client);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
