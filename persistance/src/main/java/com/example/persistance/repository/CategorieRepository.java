package com.example.persistance.repository;

import com.example.persistance.entity.Categorie;
import com.example.persistance.entity.Livre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends CrudRepository<Categorie,Long > {
    List<Categorie> findAll();

    Optional<Categorie> findById(String id);

}