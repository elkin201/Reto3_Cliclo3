package com.example.retos3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos3.entities.Ortopedic;
import com.example.retos3.repositories.OrtopedicRepository;


@Service
public class OrtopedicService {
    
        @Autowired
        private OrtopedicRepository ortopedicRepository;

        public OrtopedicService(OrtopedicRepository ortopedicRepository) {
            this.ortopedicRepository = ortopedicRepository;
        }

        public List<Ortopedic> getListOrtopedics(){
            return this.ortopedicRepository.findAll();
        }

        public Ortopedic getOrtopedic(int id){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                return this.ortopedicRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Ortopedic crearOrtopedic(Ortopedic ortopedic){
            System.out.println("service OK *************");
            return this.ortopedicRepository.save(ortopedic);
        }

        public void eliminarOrtopedic(int id){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                this.ortopedicRepository.deleteById(id);
            }
        }

        public void actualizarOrtopedic(int id, Ortopedic ortopedic){
            if(!this.ortopedicRepository.findById(id).isEmpty()){
                Ortopedic ortopedicDB = this.ortopedicRepository.findById(id).get();
                if(ortopedic.getName() != null){
                    ortopedicDB.setName(ortopedic.getName());
                }
                if(ortopedic.getBrand() != null){
                    ortopedicDB.setBrand(ortopedic.getBrand());
                }
                if(ortopedic.getDescription() != null){
                    ortopedicDB.setDescription(ortopedic.getDescription());
                }
                if(ortopedic.getYear() != null){
                    ortopedicDB.setYear(ortopedic.getYear());
                }

                this.ortopedicRepository.save(ortopedicDB);
            }
        }
}