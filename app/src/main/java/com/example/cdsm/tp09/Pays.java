package com.example.cdsm.tp09;


public class Pays {

    private String nomPays;
    private String capitalPays;
    private String drapeauPays;

    public Pays(String nomPays, String capitalPays, String drapeauPays) {
        this.nomPays = nomPays;
        this.capitalPays = capitalPays;
        this.drapeauPays = drapeauPays;
    }

    @Override
    public String toString() {
        return "Pays{" +
                "nomPays='" + nomPays + '\'' +
                ", capitalPays='" + capitalPays + '\'' +
                ", drapeauPays='" + drapeauPays + '\'' +
                '}';
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getCapitalPays() {
        return capitalPays;
    }

    public void setCapitalPays(String capitalPays) {
        this.capitalPays = capitalPays;
    }

    public String getDrapeauPays() {
        return drapeauPays;
    }

    public void setDrapeauPays(String drapeauPays) {
        this.drapeauPays = drapeauPays;
    }
}
