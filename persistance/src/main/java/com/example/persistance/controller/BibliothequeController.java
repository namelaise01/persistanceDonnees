package com.example.persistance.controller;

import com.example.persistance.entity.Auteur;
import com.example.persistance.entity.Categorie;
import com.example.persistance.entity.Emprunt;
import com.example.persistance.entity.Livre;
import com.example.persistance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class BibliothequeController {

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    EmpruntRepository empruntRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    AuteurRepository auteurRepository;

    @Autowired
    MongoTemplate mongoTemplate;



    @GetMapping(path = "/getLivre")
    @ResponseBody
    public Livre getLivre(@RequestParam Long id) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        Livre livre = new Livre();
        livre = livreOptional.isPresent() ? livreOptional.get() : null;
        return livre;
    }

    @PostMapping(path = "/deleteLivre")
    @ResponseBody
    public void deleteLivre(@RequestParam String id) {
        Optional<Livre> livreOptional = livreRepository.findById(Long.valueOf(id));
        Livre livre = livreOptional.isPresent() ? livreOptional.get() : null;
        livre.setDisable(true);
        livreRepository.save(livre);
    }

    @PostMapping(path = "/deleteCategorie")
    public void disableCategorie( @RequestParam String id ) {
        if (empruntRepository.count() ==0 ){
            return ;
        }
        Optional<Categorie> categorieOptional = categorieRepository.findById(Long.valueOf(id));
        Categorie categorie = categorieOptional.isPresent() ? categorieOptional.get() : null;
        categorie.setActive(false);
        categorieRepository.save(categorie);
    }

    @PostMapping(path = "/addEmprunt")
    @ResponseBody
    public void addEmprunt(@RequestParam String id) {

        Optional<Livre> livreOptional = livreRepository.findById(id);
        Livre livre= livreOptional.isPresent() ? livreOptional.get() : null;
        livre.setAvailable(!livre.isAvailable());
        livreRepository.save(livre);

        if (livreOptional.get().isAvailable()) {
            return;
        }

        Emprunt newEmprunt = new Emprunt();
        newEmprunt.setIdLivre(id);
        empruntRepository.save(newEmprunt);



        ;
    }
    @GetMapping(path = "/getAllLivre")
    public   List<Livre>  getAllLivre() {
        List<Livre> allLivre = livreRepository.findAllByDisable(false);
        if (allLivre.isEmpty()) {return null;}

        allLivre.forEach(livre -> {
            String categorieId = livre.getCategorieId();
            Optional<Categorie> categorie = categorieRepository.findById(categorieId);
            if (categorie.isPresent() && !categorie.get().isActive()) {
                allLivre.remove(livre);
            }
        });
        return allLivre;
    }

    @GetMapping(path = "/getCategories")
    public List<Categorie> getCategories() {
        List<Categorie> allCategories = categorieRepository.findAll();
        return allCategories;
    }

    @GetMapping(path = "/nbEmprunt")
    public int getNbEmprunt( @RequestParam String id ) {
        if (empruntRepository.count() ==0 ){
            return 0;
        }
        List<Emprunt> empruntList = empruntRepository.findAllByIdLivre(id);
        return empruntList.size();
    }
    @PostMapping(value = "/addLivre")
    @ResponseBody
    public Livre postLivre(@RequestBody  Livre livre) {
      Livre newLivre = new Livre();
        newLivre.setTitre(livre.getTitre());
        newLivre.setDate_de_parution(null);
        newLivre.setNombre_de_pages(livre.getNombre_de_pages());
        newLivre = livreRepository.save(newLivre);
        return newLivre;


    }


    @PostMapping(value = "/addAuteur")
    public void postAuteur(@RequestBody  Auteur auteur ) {
        Auteur newAuteur = new Auteur();
        newAuteur.setIdLivre(auteur.getIdLivre());
        newAuteur.setNom(auteur.getNom());
         newAuteur.setPrenom(auteur.getPrenom());
         auteurRepository.save(newAuteur);}

    @GetMapping(path = "/getCountLivre")
    public   long  getCountLivre(Model model) {
        return livreRepository.count();
    }


}
