package de.Rechnungen.Rechnungenbackend.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class KauftId implements Serializable {

    @Column(name = "Kundennummer")
    Long kundennummer;

    @Column(name = "Rechnungsnummer")
    long rechnungsnummer;

    @Column(name = "Artikelnummer")
    long artikelnummer;

    @Override
    public String toString() {
        return "KauftId{" +
                "kundennummer=" + kundennummer +
                ", rechnungsnummer=" + rechnungsnummer +
                ", artikelnummer=" + artikelnummer +
                '}';
    }
}
