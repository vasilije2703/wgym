package com.example.demo.models;

import java.math.BigDecimal;

public class Transaction {
    private int id;
    private BigDecimal iznos;
    private int teretana_pib;
    private int clan_id;

    public Transaction(int id, BigDecimal iznos, int teretana_pib, int clan_id) {
        this.id = id;
        this.iznos = iznos;
        this.teretana_pib = teretana_pib;
        this.clan_id = clan_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public int getTeretana_pib() {
        return teretana_pib;
    }

    public void setTeretana_pib(int teretana_pib) {
        this.teretana_pib = teretana_pib;
    }

    public int getClan_id() {
        return clan_id;
    }

    public void setClan_id(int clan_id) {
        this.clan_id = clan_id;
    }
}
