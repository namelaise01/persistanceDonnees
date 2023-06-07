package com.example.persistance.repository;

import com.example.persistance.entity.Categorie;
import com.example.persistance.entity.Livre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie,Long > {
    List<Categorie> findAll();
}