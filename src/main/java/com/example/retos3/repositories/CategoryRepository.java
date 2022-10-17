package com.example.retos3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.retos3.entities.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{
}
