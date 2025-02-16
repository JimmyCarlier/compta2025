package com.monapp.dao;

import com.monapp.model.PlanComptable;
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
}
