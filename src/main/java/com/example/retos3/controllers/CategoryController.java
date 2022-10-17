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

import com.example.retos3.entities.Category;
import com.example.retos3.services.CategoryService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Category")
public class CategoryController {    

    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategorys(){
        return new ResponseEntity<List<Category>>(this.categoryService.getListCategorys(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable("id") int id){
        return new ResponseEntity<Category>(this.categoryService.getCategory(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearCategory(@RequestBody Category category){
        this.categoryService.crearCategory(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategory(@PathVariable("id") int id){
        this.categoryService.eliminarCategory(id);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarCategory(@RequestBody Category category){
        this.categoryService.actualizarCategory(category.getId(), category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
