package com.example.persistance.repository;

import com.example.persistance.entity.Auteur;
import org.springframework.data.repository.CrudRepository;

public interface AuteurRepository extends CrudRepository<Auteur,Long > {
}
