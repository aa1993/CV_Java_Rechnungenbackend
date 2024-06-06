package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RechnungRepository extends CrudRepository<Rechnung, Long> {

    // Liste aller Produkte, die in der Rechnung mit der einer gegebenen Rechnungsnummer enthalten sind
    // folgende Informationen werden dabei gegeben artikelnummer, produktname, preis, anzahl, gesamtpreis
    @Query(value = "SELECT p.artikelnummer AS artikelnummer, p.produktname AS produktname, p.preis AS preis, e.anzahl AS anzahl, (p.preis*e.anzahl) AS gesamtpreis FROM  enthaelt AS e INNER JOIN Produkt AS p ON p.artikelnummer = e.artikelnummer WHERE e.rechnungsnummer = ?1", nativeQuery = true)
    List<Rechnungseintrag> getRechnungsliste(long rechnungsnummer);

    @Query(value = "SELECT p.artikelnummer AS artikelnummer, p.produktname AS produktname, p.preis AS preis, e.anzahl AS anzahl, (p.preis*e.anzahl) AS gesamtpreis FROM  enthaelt AS e INNER JOIN Produkt AS p ON p.artikelnummer = e.artikelnummer WHERE e.rechnungsnummer = ?1 AND e.artikelnummer = ?2", nativeQuery = true)
    Optional<Rechnungseintrag> getRechnungseintrag(long rechnungsnummer, long artikelnummer);

    @Modifying
    @Query(value = "INSERT INTO enthaelt (rechnungsnummer, artikelnummer, anzahl) VALUE (?1, ?2, ?3)", nativeQuery = true)
    void addRechnungseintrag(long rechnungsnummer, long artikelnummer, long anzahl);

    @Modifying
    @Query(value = "DELETE FROM enthaelt WHERE rechnungsnummer = ?1 AND artikelnummer = ?2", nativeQuery = true)
    void deleteRechnungseintrag(long rechnungsnummer, long artikelnummer);

    @Modifying
    @Query(value = "UPDATE enthaelt SET anzahl = ?3 WHERE artikelnummer = ?2 AND rechnungsnummer = ?1", nativeQuery = true)
    void updateRechnungseintrag(long rechnungsnummer, long artikelnummer, long anzahl);

    // der Gesamtpreis für eine komplette Rechnung mit gegebener Rechnungsnummer
    @Query(value = "SELECT SUM(p.preis*e.anzahl) AS totalpreis FROM produkt AS p INNER JOIN enthaelt AS e ON p.Artikelnummer = e.Artikelnummer WHERE e.Rechnungsnummer = ?1 GROUP BY e.Rechnungsnummer", nativeQuery = true)
    List<Totalpreis> getTotalpreisVonRechnungsnummer(long rechnungsnummer);
}
