package com.monapp.dao;

import com.monapp.model.PlanComptable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlanComptableDAO {

    private final JdbcTemplate jdbcTemplate;

    // Injection du JdbcTemplate dans le DAO via le constructeur
    @Autowired
    public PlanComptableDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Méthode pour insérer un plan comptable dans la base de données
    public void save(PlanComptable planComptable) {
        String sql = "INSERT INTO plan_comptable (nom, mois,annee,oldSolde) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, planComptable.getNom(), planComptable.getMois(), planComptable.getAnnee(),
                planComptable.getOldSolde());
    }

    public List<PlanComptable> getAllPlans() {
        String sql = "SELECT * FROM plan_comptable";

        // Utilisation de query pour récupérer tous les résultats
        List<PlanComptable> plans = jdbcTemplate.query(sql, (rs, rowNum) -> {
            PlanComptable plan = new PlanComptable();
            plan.setId(rs.getLong("id"));
            plan.setNom(rs.getString("nom"));
            plan.setMois(rs.getString("mois"));
            plan.setAnnee(rs.getInt("annee"));
            plan.setOldSolde(rs.getBigDecimal("oldSolde"));
            return plan;
        });

        System.out.println("Plans Comptables récupérés: " + plans.size()); // Vérification du nombre de plans récupérés
        return plans;
    }

}
