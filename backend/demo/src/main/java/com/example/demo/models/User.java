package com.example.demo.models;

import java.math.BigDecimal;
import java.sql.Date;

public class User {
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private String password_hash;
    private Integer visina; // Promenjeno u Integer
    private BigDecimal tezina;
    private Date datum_rodjenja;
    private int uloga_id; // Pretpostavka: uloga_id ne može biti null
    private Integer teretana_pib; // Promenjeno u Integer

    public User(int id, String ime, String prezime, String email, String password_hash, Integer visina, BigDecimal tezina, Date datum_rodjenja, int uloga_id, Integer teretana_pib) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password_hash = password_hash;
        this.visina = visina;
        this.tezina = tezina;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga_id = uloga_id;
        this.teretana_pib = teretana_pib;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public Integer getVisina() {
        return visina;
    }

    public void setVisina(Integer visina) {
        this.visina = visina;
    }

    public BigDecimal getTezina() {
        return tezina;
    }

    public void setTezina(BigDecimal tezina) {
        this.tezina = tezina;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public int getUloga_id() {
        return uloga_id;
    }

    public void setUloga_id(int uloga_id) {
        this.uloga_id = uloga_id;
    }

    public Integer getTeretana_pib() {
        return teretana_pib;
    }

    public void setTeretana_pib(Integer teretana_pib) {
        this.teretana_pib = teretana_pib;
    }
}