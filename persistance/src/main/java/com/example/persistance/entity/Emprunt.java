package com.example.persistance.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Emprunt {
    @Id
    private Long id;

    private Long LivreId;

    private Date date_emprunt;

    private Date date_fin_prevue;

    private Date date_retour;


}
