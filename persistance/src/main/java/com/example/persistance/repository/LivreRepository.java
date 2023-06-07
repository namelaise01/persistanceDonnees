package com.example.persistance.repository;

import com.example.persistance.entity.Livre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivreRepository extends CrudRepository<Livre,Long > {

    List<Livre> findAll();
}
