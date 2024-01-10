package de.Rechnungen.Rechnungenbackend.Json;

public class EnthaeltJson {

    private long rechnungsnummer;
    private long artikelnummer;

    private int anzahl;

    public EnthaeltJson() {
    }

    public EnthaeltJson(long rechnungsnummer, long artikelnummer, int anzahl) {
        this.rechnungsnummer = rechnungsnummer;
        this.artikelnummer = artikelnummer;
        this.anzahl = anzahl;
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

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
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
