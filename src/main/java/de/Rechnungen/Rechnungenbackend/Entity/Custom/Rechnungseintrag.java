package de.Rechnungen.Rechnungenbackend.Entity.Custom;

public interface Rechnungseintrag {
    long getArtikelnummer();
    String getProduktname();
    double getPreis();
    int getAnzahl();
}
