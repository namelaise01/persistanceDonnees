package com.example.persistance.repository;

import com.example.persistance.entity.Livre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends CrudRepository<Livre,Long > {


    List<Livre> findAll();

    List<Livre> findAllByDisable(boolean isDisabled);

    Optional<Livre> findById(String id);
}
