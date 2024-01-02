package de.Rechnungen.Rechnungenbackend.Entity.Custom;

public interface KundeKauftProduktInRechnung {
    long getKundennummer();
    String getVorname();
    String getNachname();
    String getStrasse();
    int getHausnummer();
    int getPLZ();
    String getOrt();
    long getRechnungsnummer();
    long getArtikelnummer();
    int getAnzahl();
}
