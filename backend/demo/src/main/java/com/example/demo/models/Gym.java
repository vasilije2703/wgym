package com.example.demo.models;

public class Gym {
    private int pib;
    private String naziv;
    private String adresa;
    private String grad;
    private String drzava;
    private int clanarina_eur;
    private int vlasnik_id;

    public Gym(int pib, String naziv, String adresa, String grad, String drzava, int clanarina_eur, int vlasnik_id) {
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.clanarina_eur = clanarina_eur;
        this.vlasnik_id = vlasnik_id;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public int getClanarina_eur() {
        return clanarina_eur;
    }

    public void setClanarina_eur(int clanarina_eur) {
        this.clanarina_eur = clanarina_eur;
    }

    public int getVlasnik_id() {
        return vlasnik_id;
    }

    public void setVlasnik_id(int vlasnik_id) {
        this.vlasnik_id = vlasnik_id;
    }
}
