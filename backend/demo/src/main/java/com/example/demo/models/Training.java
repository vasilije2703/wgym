package com.example.demo.models;

import java.sql.Date;

public class Training {
    private int id;
    private Date datum;
    private int clan_id;
    private int tip_treninga_id;

    public Training(int id, Date datum, int clan_id, int tip_treninga_id) {
        this.id = id;
        this.datum = datum;
        this.clan_id = clan_id;
        this.tip_treninga_id = tip_treninga_id;
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

    public int getClan_id() {
        return clan_id;
    }

    public void setClan_id(int clan_id) {
        this.clan_id = clan_id;
    }

    public int getTip_treninga_id() {
        return tip_treninga_id;
    }

    public void setTip_treninga_id(int tip_treninga_id) {
        this.tip_treninga_id = tip_treninga_id;
    }
}
