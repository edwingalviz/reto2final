/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.g8.services;

import com.example.g8.entities.Clothe;
import com.example.g8.repositories.ClotheRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bmao9
 */
@Service
public class ClotheService {
    
    @Autowired
    public ClotheRepository repository;
    
    public List<Clothe> getAllClothe(){
        return (List<Clothe>) repository.getAllClothe();
    }
    
    public Optional<Clothe> getClotheId(Integer id){
        return repository.getClotheId(id);
    }
    
    public List<Clothe> getClothePrice(Float price){
        return repository.getClothePrice(price);
    }
    
    public Optional<Clothe> getClotheReference(String reference){
        return repository.getClotheReference(reference);
    }
    
    public List<Clothe> getCDescription(String description){
        List <Clothe>ListaFechas = new ArrayList<Clothe>();
        for(Clothe x: repository.getAllClothe()){
            if(x.getDescription().toLowerCase().contains(description)){
                ListaFechas.add(x);
            }
        }
        return ListaFechas;
    }
    
    
   public Clothe createClothe(Clothe clotheNew){
       return repository.createClothe(clotheNew);
   }
   
   public Clothe update(Clothe clotheEdit){
        if(clotheEdit.getReference()!=null){
            Optional<Clothe> resultado = repository.getClotheReference(clotheEdit.getReference());
            if(resultado.isPresent()){
                if(clotheEdit.isAvailability()){
                    resultado.get().setAvailability(clotheEdit.isAvailability());
                }
                if(clotheEdit.getCategory()!=null){
                    resultado.get().setCategory(clotheEdit.getCategory());
                }
                if(clotheEdit.getDescription()!=null){
                    resultado.get().setDescription(clotheEdit.getDescription());
                }
                if(clotheEdit.getPhotography()!=null){
                    resultado.get().setPhotography(clotheEdit.getPhotography());
                }
                if(clotheEdit.getPrice()!= null){
                    resultado.get().setPrice(clotheEdit.getPrice());
                }
                if(clotheEdit.getQuantity()!=null){
                    resultado.get().setQuantity(clotheEdit.getQuantity());
                }
                if(clotheEdit.getSize()!=null){
                    resultado.get().setSize(clotheEdit.getSize());
                }
                repository.createClothe(resultado.get());
                return resultado.get();
            }else{
                return clotheEdit;
            }
        }else{
            return clotheEdit;
        }
    }
   
   public boolean delete(String id){
        Boolean aBoolean = getClotheReference(id).map(eliminado -> {
           repository.delete(eliminado);
           return true;
        }).orElse(false);
        return aBoolean;
    } 
    
    
}

