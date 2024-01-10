package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "enthaelt")
public class Enthaelt {

    @EmbeddedId
    private EnthaeltId id;

/*
    @ManyToOne
    @MapsId("rechnungsnummer")
    @JoinColumn(name = "rechnungsnummer")
    private Rechnung rechnung;

    @ManyToOne
    @MapsId("artikelnummer")
    @JoinColumn(name = "artikelnummer")
    private Produkt produkt;
*/

    @Column(name = "anzahl", nullable = false)
    private int anzahl;

    public Enthaelt() {
    }

    public Enthaelt(EnthaeltId id, int anzahl) {
        this.id = id;
        this.anzahl = anzahl;
    }

    public Enthaelt(int anzahl) {
        this.anzahl = anzahl;
    }

    /*
            public Enthaelt(EnthaeltId id, Rechnung rechnung, Produkt produkt, int anzahl) {
                this.id = id;
                this.rechnung = rechnung;
                this.produkt = produkt;
                this.anzahl = anzahl;
            }

            public Enthaelt(Rechnung rechnung, Produkt produkt, int anzahl) {
                this.rechnung = rechnung;
                this.produkt = produkt;
                this.anzahl = anzahl;
            }
        */
    public EnthaeltId getId() {
        return id;
    }

    public void setId(EnthaeltId id) {
        this.id = id;
    }

    /*
    @JsonBackReference
    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }
*/

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }



}
