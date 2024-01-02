package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "kauft")
public class Kauft {

    @EmbeddedId
    private KauftId id;

    @ManyToOne
    @MapsId("kundennummer")// variablename in der Kunde Klasse
    @JoinColumn(name = "Kundennummer")// Spaltenname in der Tabelle Kauft
    private Kunde kunde;

    @ManyToOne
    @MapsId("rechnungsnummer")// variablename in der Rechnung Klasse
    @JoinColumn(name = "Rechnungsnummer")// Spaltenname in der Tabelle Kauft
    private Rechnung rechnung;

    @ManyToOne
    @MapsId("artikelnummer")// variablename in der Produkt Klasse
    @JoinColumn(name = "Artikelnummer")// Spaltenname in der Tabelle Kauft
    private Produkt produkt;


    @Column(name = "Anzahl", nullable = false)
    private int anzahl;

    public Kauft() {
    }

    public Kauft(KauftId id, Kunde kunde, Rechnung rechnung, Produkt produkt, int anzahl) {
        this.id = id;
        this.kunde = kunde;
        this.rechnung = rechnung;
        this.produkt = produkt;
        this.anzahl = anzahl;
    }

    public Kauft(Kunde kunde, Rechnung rechnung, Produkt produkt, int anzahl) {
        this.kunde = kunde;
        this.rechnung = rechnung;
        this.produkt = produkt;
        this.anzahl = anzahl;
    }

    public KauftId getId() {
        return id;
    }

    public void setId(KauftId id) {
        this.id = id;
    }

    @JsonBackReference
    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @JsonBackReference
    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    @JsonBackReference
    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }


}
