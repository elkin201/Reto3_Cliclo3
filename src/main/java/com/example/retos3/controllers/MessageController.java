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

import com.example.retos3.entities.Message;
import com.example.retos3.services.MessageService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Message")
public class MessageController {    

    @Autowired
    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getMessages(){
        return new ResponseEntity<List<Message>>(this.messageService.getListMessages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id") int id){
        return new ResponseEntity<Message>(this.messageService.getMessage(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearMessage(@RequestBody Message message){
        this.messageService.crearMessage(message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMessage(@PathVariable("id") int id){
        this.messageService.eliminarMessage(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarMessage(@RequestBody Message message){
        this.messageService.actualizarMessage(message.getIdMessage(), message);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
