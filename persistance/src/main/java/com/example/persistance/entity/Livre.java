package com.example.persistance.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
public class Livre {

    private Long id;

    private String titre;

    private Date date_de_parution;

    private int nombre_de_pages;

    private int categorieId;


}
