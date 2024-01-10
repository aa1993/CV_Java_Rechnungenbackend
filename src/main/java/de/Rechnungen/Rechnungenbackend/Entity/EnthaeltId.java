package de.Rechnungen.Rechnungenbackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;

@Embeddable
public class EnthaeltId implements Serializable {

    @Column(name = "rechnungsnummer")
    private long rechnungsnummer;

    @Column(name = "artikelnummer")
    private long artikelnummer;

    public EnthaeltId() {
    }

    public EnthaeltId(long rechnungsnummer, long artikelnummer) {
        this.rechnungsnummer = rechnungsnummer;
        this.artikelnummer = artikelnummer;
    }

    public long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public void setRechnungsnummer(long rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }
}
