package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomQueryRepo extends JpaRepository<Rechnung, Long> {

    // Liste
    @Query(value = "SELECT p.artikelnummer AS artikelnummer, p.produktname AS produktname, p.preis AS preis, e.anzahl AS anzahl, (p.preis*e.anzahl) AS gesamtpreis FROM  enthaelt AS e INNER JOIN Produkt AS p ON p.artikelnummer = e.artikelnummer WHERE e.rechnungsnummer = ?1", nativeQuery = true)
    List<Rechnungseintrag> getRechnungsliste(long Rechnungsnummer);

    @Query(value = "SELECT SUM(p.preis*e.anzahl) AS totalpreis FROM produkt AS p INNER JOIN enthaelt AS e ON p.Artikelnummer = e.Artikelnummer WHERE e.Rechnungsnummer = ?1 GROUP BY e.Rechnungsnummer", nativeQuery = true)
    List<Totalpreis> getTotalpreisVonRechnungsnummer(long Rechnungsnummer);
}
