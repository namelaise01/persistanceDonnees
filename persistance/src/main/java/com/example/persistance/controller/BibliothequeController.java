package com.example.persistance.controller;

import com.example.persistance.entity.Categorie;
import com.example.persistance.entity.Livre;
import com.example.persistance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    AdherentRepository adherentRepository;

    @GetMapping(path = "/getLivre")
    @ResponseBody
    public Livre getLivre(@RequestParam Long id) {
        Optional<Livre> livreOptional = livreRepository.findById(id);
        Livre livre = new Livre();
        livre = livreOptional.isPresent() ? livreOptional.get() : null;
        return livre;
    }

    @GetMapping(path = "/getAllLivre")
    public   List<Livre>  getAllLivre() {
        List<Livre> allLivre = livreRepository.findAll();
        return allLivre;
    }
    @GetMapping(path = "/getCategories")
    public List<Categorie> getCategories() {
        List<Categorie> allCategories = categorieRepository.findAll();
        return allCategories;
    }

    @RequestMapping(value = "/createLivre", method = RequestMethod.POST)
    @ResponseBody
    public long postLivre(@ModelAttribute Livre livre) {
      //  Livre livre = new Livre();
      //  livre.setTitre(titre);
      //  livre.setDate_de_parution(date);
       // livre.setNombre_de_pages(pages);
        livreRepository.save(livre);
        System.out.print("Il y a " + livreRepository.count() + " livre en base de données.");
        return livreRepository.count();

    }

    @GetMapping(path = "/getCountLivre")
    public   long  getCountLivre(Model model) {
        return livreRepository.count();
    }


}
