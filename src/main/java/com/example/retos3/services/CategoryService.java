package com.example.retos3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos3.entities.Category;
import com.example.retos3.repositories.CategoryRepository;


@Service
public class CategoryService {
    
        @Autowired
        private CategoryRepository categoryRepository;

        public CategoryService(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        public List<Category> getListCategorys(){
            return this.categoryRepository.findAll();
        }

        public Category getCategory(int id){
            if(!this.categoryRepository.findById(id).isEmpty()){
                return this.categoryRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Category crearCategory(Category category){
            return this.categoryRepository.save(category);
        }

        public void eliminarCategory(int id){
            if(!this.categoryRepository.findById(id).isEmpty()){
                this.categoryRepository.deleteById(id);
            }
        }

        public void actualizarCategory(int id, Category category){
            if(!this.categoryRepository.findById(id).isEmpty()){
                Category categoryDB = this.categoryRepository.findById(id).get();
                
                if(category.getName() != null){
                    categoryDB.setName(category.getName());
                }
                if(category.getDescription() != null){
                    categoryDB.setDescription(category.getDescription());
                }
                this.categoryRepository.save(categoryDB);
            }
        }
}
