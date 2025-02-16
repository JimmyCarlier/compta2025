package com.monapp.controller;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.monapp.dao.PlanComptableDAO;
import com.monapp.model.PlanComptable;

@Controller
public class HelloController {

    // Déclaration de l'objet DAO pour interagir avec la base de données
    private final PlanComptableDAO planComptableDAO;
    private int year = Year.now().getValue();

    // Constructeur du contrôleur, qui reçoit le PlanComptableDAO pour l'injection
    // de dépendances
    public HelloController(PlanComptableDAO planComptableDAO) {
        this.planComptableDAO = planComptableDAO;
    }

    // Cette méthode affiche la page d'accueil
    @GetMapping("/")
    public String getCurrentPlan(Model model) {
        List<PlanComptable> allPlans = planComptableDAO.getAllPlans();

        // Permet d'itérer sur le tableau
        // Iterator<PlanComptable> iterator = allPlans.iterator();
        // while (iterator.hasNext()) {
        // PlanComptable plan = iterator.next();

        // System.out.println(plan.getNom());
        // }

        // Ajout d'un attribut "title" dans le modèle
        model.addAttribute("title", "Comptabilité " + Year.now().getValue());
        model.addAttribute("planList", allPlans);

        // Retourne la vue "home" qui sera affichée
        return "home";
    }

    // Cette méthode gère la soumission du formulaire via POST
    @PostMapping("/addCompta")
    public String newCompta(@RequestParam String nom, // Paramètre "nom" récupéré du formulaire
            @RequestParam String mois, // Paramètre "mois" récupéré du formulaire
            @RequestParam int annee, // Paramètre "annee" récupéré du formulaire
            @RequestParam BigDecimal oldSolde, // Paramètre "oldSolde" récupéré du formulaire
            Model model) {

        // Création d'une nouvelle instance de PlanComptable avec les valeurs récupérées
        PlanComptable currentPlan = new PlanComptable();
        currentPlan.setNom(nom);
        currentPlan.setMois(mois);
        currentPlan.setAnnee(annee);
        currentPlan.setOldSolde(oldSolde);

        // Enregistrement du nouvel objet PlanComptable dans la base de données via le
        // DAO
        planComptableDAO.save(currentPlan);

        // Ajout de l'objet PlanComptable au modèle pour éventuellement l'afficher dans
        // la vue
        model.addAttribute("plan", currentPlan);
        model.addAttribute("mois", this.getStringMonth(currentPlan.getMois()));
        model.addAttribute("title", "Comptabilité " + year);

        // Redirection vers la page d'accueil après l'ajout réussi
        return "home";
    }

    private String getStringMonth(String month) {
        String stringMonth = "";
        switch (month) {
            case "01":
                stringMonth = "Janvier";
                break;
            case "02":
                stringMonth = "Février";
                break;
            case "03":
                stringMonth = "Mars";
                break;
            case "04":
                stringMonth = "Avril";
                break;
            case "05":
                stringMonth = "Mai";
                break;
            case "06":
                stringMonth = "Juin";
                break;
            case "07":
                stringMonth = "Juillet";
                break;
            case "08":
                stringMonth = "Août";
                break;
            case "09":
                stringMonth = "Septembre";
                break;
            case "10":
                stringMonth = "Octobre";
                break;
            case "11":
                stringMonth = "Novembre";
                break;
            case "12":
                stringMonth = "Décembre";
                break;
            default:
                stringMonth = "Mois invalide"; // Gestion du cas où le mois est incorrect
                break;
        }
        return stringMonth;
    }

}
