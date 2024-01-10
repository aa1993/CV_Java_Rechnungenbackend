package de.Rechnungen.Rechnungenbackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "enthaelt")
public class Enthaelt {

    @EmbeddedId
    private EnthaeltId id;

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
    public EnthaeltId getId() {
        return id;
    }

    public void setId(EnthaeltId id) {
        this.id = id;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }



}
