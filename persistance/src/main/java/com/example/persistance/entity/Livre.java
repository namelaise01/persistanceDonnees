package com.example.persistance.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
@ToString(callSuper = true)
public class Livre {

    @Id
    private String id;

    private String titre;

    private Date date_de_parution;

    private int nombre_de_pages;

    private String categorieId;

    private String auteurId;

    private boolean disable = false;

    private boolean available = true;

}
