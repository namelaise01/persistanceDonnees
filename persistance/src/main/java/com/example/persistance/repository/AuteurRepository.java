package com.example.persistance.repository;

import com.example.persistance.entity.Auteur;
import com.example.persistance.entity.Categorie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuteurRepository extends CrudRepository<Auteur,Long > {

    List<Auteur> findAll();
}
