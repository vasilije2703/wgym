package com.example.demo.dto;

import java.math.BigDecimal;
import java.sql.Date;


public class SignUpRequest {
    public String ime;
    public String prezime;
    public String email;
    public String password;
    public Integer visina;
    public BigDecimal tezina;
    public Date datum_rodjenja;
    public Integer uloga_id;
    public Integer teretana_pib;

    public SignUpRequest(String ime, String prezime, String email, String password, Integer visina, BigDecimal tezina, Date datum_rodjenja, Integer uloga_id, Integer teretana_pib) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.visina = visina;
        this.tezina = tezina;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga_id = uloga_id;
        this.teretana_pib = teretana_pib;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getUloga_id() {
        return uloga_id;
    }

    public void setUloga_id(Integer uloga_id) {
        this.uloga_id = uloga_id;
    }

    public Integer getTeretana_pib() {
        return teretana_pib;
    }

    public void setTeretana_pib(Integer teretana_pib) {
        this.teretana_pib = teretana_pib;
    }
}
