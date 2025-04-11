CREATE DATABASE wgym;
USE wgym;

CREATE TABLE uloga(
     id INT PRIMARY KEY auto_increment,
     naziv VARCHAR(50)
);

CREATE TABLE tip_treninga(
	 id INT PRIMARY KEY auto_increment,
     naziv VARCHAR(50)
);

CREATE TABLE hrana(
    id INT PRIMARY KEY auto_increment,
    naziv VARCHAR(100) NOT NULL, 
    kalorije DECIMAL(7,2) DEFAULT 0 CHECK (kalorije >= 0), 
    proteini DECIMAL(7,2) DEFAULT 0 CHECK (proteini >= 0),
    ugljeni_hidrati DECIMAL(7,2) DEFAULT 0 CHECK (ugljeni_hidrati >= 0),
    seceri DECIMAL(7,2) DEFAULT 0 CHECK (seceri >= 0),
    vlakna DECIMAL(7,2) DEFAULT 0 CHECK (vlakna >= 0),
    masti DECIMAL(7,2) DEFAULT 0 CHECK (masti >= 0),
    kolicina_gram DECIMAL(7,2) CHECK (kolicina_gram > 0)
);

CREATE TABLE korisnik(
	id INT PRIMARY KEY auto_increment,
    ime VARCHAR(100) NOT NULL,
    prezime VARCHAR(100) NOT NULL,
    email VARCHAR(254) UNIQUE,
    password_hash VARCHAR(128),
    visina INT,
    tezina DECIMAL(5,2),
    datum_rodjenja DATE,
	uloga_id INT NOT NULL,
    teretana_pib INT,
    FOREIGN KEY (uloga_id) REFERENCES uloga(id)
);


CREATE TABLE teretana(
	pib INT PRIMARY KEY CHECK (pib >= 100000000 AND pib <= 999999999),
    naziv VARCHAR(100),
    adresa VARCHAR(100),
    grad VARCHAR(100),
    drzava VARCHAR(100),
    clanarina_eur  INT DEFAULT 0 CHECK (clanarina_eur >= 0),
    vlasnik_id INT NOT NULL,
    FOREIGN KEY (vlasnik_id) REFERENCES korisnik(id)
);

ALTER TABLE korisnik
ADD CONSTRAINT fk_clan_teretana
FOREIGN KEY (teretana_pib) 
REFERENCES teretana(pib);


CREATE TABLE transakcija(
	id INT PRIMARY KEY auto_increment,
    iznos DECIMAL(7,2),
    teretana_pib INT NOT NULL,
    clan_id INT NOT NULL,
    FOREIGN KEY (teretana_pib) REFERENCES teretana(pib),
	FOREIGN KEY (clan_id) REFERENCES korisnik(id)
);

CREATE TABLE trening(
	id INT PRIMARY KEY auto_increment,
    datum DATE NOT NULL,
    clan_id INT NOT NULL,
    tip_treninga_id INT NOT NULL,
    FOREIGN KEY (tip_treninga_id) REFERENCES tip_treninga(id),
    FOREIGN KEY (clan_id) REFERENCES korisnik(id)    
);

CREATE TABLE obrok(
    id INT PRIMARY KEY auto_increment,
    datum DATE NOT NULL,
    hrana_id INT NOT NULL,
    korisnik_id INT NOT NULL,
    FOREIGN KEY (hrana_id) REFERENCES hrana(id),
    FOREIGN KEY (korisnik_id) REFERENCES korisnik(id)
);