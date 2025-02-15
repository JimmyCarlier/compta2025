package com.monapp.model;

import java.math.BigDecimal;

public class PlanComptable {

    private String nom;
    private String mois;
    private int annee;
    private BigDecimal oldSolde;

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public BigDecimal getOldSolde() {
        return oldSolde;
    }

    public void setOldSolde(BigDecimal oldSolde) {
        this.oldSolde = oldSolde;
    }
}
