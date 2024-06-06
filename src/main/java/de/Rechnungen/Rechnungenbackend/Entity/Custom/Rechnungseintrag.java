package de.Rechnungen.Rechnungenbackend.Entity.Custom;

public interface Rechnungseintrag {
    Long getArtikelnummer();
    String getProduktname();
    Double getPreis();
    Integer getAnzahl();
    Double getGesamtpreis();
}
