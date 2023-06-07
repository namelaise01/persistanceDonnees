package com.example.persistance.repository;

import com.example.persistance.entity.Emprunt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpruntRepository extends CrudRepository<Emprunt,Long > {

    List<Emprunt>  findAllByIdLivre(String id);
}
