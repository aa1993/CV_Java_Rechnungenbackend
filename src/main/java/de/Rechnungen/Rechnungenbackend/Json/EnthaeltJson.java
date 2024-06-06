package de.Rechnungen.Rechnungenbackend.Json;

public class EnthaeltJson {

    private Long rechnungsnummer;
    private Long artikelnummer;

    private Integer anzahl;

    public EnthaeltJson() {
    }

    public EnthaeltJson(Long rechnungsnummer, Long artikelnummer, Integer anzahl) {
        this.rechnungsnummer = rechnungsnummer;
        this.artikelnummer = artikelnummer;
        this.anzahl = anzahl;
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

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return "EnthaeltJson{" +
                "rechnungsnummer=" + rechnungsnummer +
                ", artikelnummer=" + artikelnummer +
                ", anzahl=" + anzahl +
                '}';
    }
}
