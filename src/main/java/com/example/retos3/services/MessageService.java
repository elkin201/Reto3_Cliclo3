package com.example.retos3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos3.entities.Message;
import com.example.retos3.repositories.MessageRepository;


@Service
public class MessageService {
    
        @Autowired
        private MessageRepository messageRepository;

        public MessageService(MessageRepository messageRepository) {
            this.messageRepository = messageRepository;
        }

        public List<Message> getListMessages(){
            return this.messageRepository.findAll();
        }

        public Message getMessage(int id){
            if(!this.messageRepository.findById(id).isEmpty()){
                return this.messageRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Message crearMessage(Message message){
            return this.messageRepository.save(message);
        }

        public void eliminarMessage(int id){
            if(!this.messageRepository.findById(id).isEmpty()){
                this.messageRepository.deleteById(id);
            }
        }

        public void actualizarMessage(int id, Message message){
            if(!this.messageRepository.findById(id).isEmpty()){
                Message messageDB = this.messageRepository.findById(id).get();
                if(message.getMessageText() != null){
                    messageDB.setMessageText(message.getMessageText());
                }
                this.messageRepository.save(messageDB);
            }
        }
}