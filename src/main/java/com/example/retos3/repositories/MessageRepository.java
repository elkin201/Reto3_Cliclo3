package com.example.retos3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos3.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Integer>{
}
