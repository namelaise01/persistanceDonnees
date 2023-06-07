package com.example.persistance.repository;

import com.example.persistance.entity.Emprunt;
import org.springframework.data.repository.CrudRepository;

public interface EmpruntRepository extends CrudRepository<Emprunt,Long > {
}
