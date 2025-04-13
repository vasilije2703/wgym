package com.example.demo.models;

import java.math.BigDecimal;

public class Food {
    private int id;
    private String naziv;
    private BigDecimal kalorije;
    private BigDecimal proteini;
    private BigDecimal ugljeni_hidrati;
    private BigDecimal seceri;
    private BigDecimal vlakna;
    private BigDecimal masti;
    private BigDecimal kolicina_gram;

    public Food(int id, String naziv, BigDecimal kalorije, BigDecimal proteini, BigDecimal ugljeni_hidrati, BigDecimal seceri, BigDecimal masti, BigDecimal vlakna, BigDecimal kolicina_gram) {
        this.id = id;
        this.naziv = naziv;
        this.kalorije = kalorije;
        this.proteini = proteini;
        this.ugljeni_hidrati = ugljeni_hidrati;
        this.seceri = seceri;
        this.masti = masti;
        this.vlakna = vlakna;
        this.kolicina_gram = kolicina_gram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getKalorije() {
        return kalorije;
    }

    public void setKalorije(BigDecimal kalorije) {
        this.kalorije = kalorije;
    }

    public BigDecimal getProteini() {
        return proteini;
    }

    public void setProteini(BigDecimal proteini) {
        this.proteini = proteini;
    }

    public BigDecimal getUgljeni_hidrati() {
        return ugljeni_hidrati;
    }

    public void setUgljeni_hidrati(BigDecimal ugljeni_hidrati) {
        this.ugljeni_hidrati = ugljeni_hidrati;
    }

    public BigDecimal getSeceri() {
        return seceri;
    }

    public void setSeceri(BigDecimal seceri) {
        this.seceri = seceri;
    }

    public BigDecimal getVlakna() {
        return vlakna;
    }

    public void setVlakna(BigDecimal vlakna) {
        this.vlakna = vlakna;
    }

    public BigDecimal getMasti() {
        return masti;
    }

    public void setMasti(BigDecimal masti) {
        this.masti = masti;
    }

    public BigDecimal getKolicina_gram() {
        return kolicina_gram;
    }

    public void setKolicina_gram(BigDecimal kolicina_gram) {
        this.kolicina_gram = kolicina_gram;
    }
}
