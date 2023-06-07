package com.example.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Adherent {
    @Id
    private String id;

    private String nom;

    private String prenom;

    private String email;

    private Date date_inscription;


}
