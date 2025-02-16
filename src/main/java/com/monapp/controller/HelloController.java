package com.monapp.controller;

import java.math.BigDecimal;
import java.time.Year;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.monapp.dao.PlanComptableDAO;
import com.monapp.model.PlanComptable;

@Controller
public class HelloController {

    private final PlanComptableDAO planComptableDAO;

    // Constructeur
    public HelloController(PlanComptableDAO planComptableDAO) {
        this.planComptableDAO = planComptableDAO;
    }

    // Affiche la page d'accueil
    @GetMapping("/")
    public String hello(Model model) {
        int year = Year.now().getValue();
        model.addAttribute("title", "Comptabilité " + year);
        return "home"; // Affiche home.html
    }

    // Traitement du formulaire
    @PostMapping("/addCompta")
    public String newCompta(@RequestParam String nom,
            @RequestParam String mois,
            @RequestParam int annee,
            @RequestParam BigDecimal oldSolde,
            Model model) {

        PlanComptable currentPlan = new PlanComptable();
        currentPlan.setNom(nom);
        currentPlan.setMois(mois);
        currentPlan.setAnnee(annee);
        currentPlan.setOldSolde(oldSolde);

        // Enregistrement dans la base
        planComptableDAO.save(currentPlan);

        // Ajout au modèle si besoin
        model.addAttribute("plan", currentPlan);

        return "redirect:/";
    }
}
