package com.example.demo.models;

import java.sql.Date;

public class Meal {
    private int id;
    private Date datum;
    private int hrana_id;
    private int korisnik_id;

    public Meal(int id, Date datum, int hrana_id, int korisnik_id) {
        this.id = id;
        this.datum = datum;
        this.hrana_id = hrana_id;
        this.korisnik_id = korisnik_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getHrana_id() {
        return hrana_id;
    }

    public void setHrana_id(int hrana_id) {
        this.hrana_id = hrana_id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }
}
