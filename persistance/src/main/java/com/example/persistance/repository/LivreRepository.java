package com.example.persistance.repository;

import com.example.persistance.entity.Livre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LivreRepository extends CrudRepository<Livre,Long > {


    List<Livre> findAll();

    List<Livre> findAllByDisable(boolean isDisabled);

    List<Livre> findAllByDisableAndAvailable(boolean isDisabled, boolean isAvailable);

    Optional<Livre> findById(String id);

    Optional<Livre> findByAuteurId(String id);
}
