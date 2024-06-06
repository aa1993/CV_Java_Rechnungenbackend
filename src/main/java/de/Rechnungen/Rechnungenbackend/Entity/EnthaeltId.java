package de.Rechnungen.Rechnungenbackend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;

import java.io.Serializable;

@Embeddable
public class EnthaeltId implements Serializable {

    @Column(name = "rechnungsnummer")
    private Long rechnungsnummer;

    @Column(name = "artikelnummer")
    private Long artikelnummer;

    public EnthaeltId() {
    }

    public EnthaeltId(Long rechnungsnummer, Long artikelnummer) {
        this.rechnungsnummer = rechnungsnummer;
        this.artikelnummer = artikelnummer;
    }

    public Long getRechnungsnummer() {
        return rechnungsnummer;
    }

    public void setRechnungsnummer(Long rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public Long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }
}
