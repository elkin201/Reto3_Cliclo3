package com.example.retos3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos3.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
}
