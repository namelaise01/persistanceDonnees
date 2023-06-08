package com.example.persistance.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
public class Auteur {
    @Id
    private String id;


    private String nom;

    private String prenom;





}
