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

    @Query(value = "SELECT p.Artikelnummer AS artikelnummer, p.Produktname AS produktname, p.Preis AS preis, ka.Anzahl AS anzahl, (p.Preis*ka.Anzahl) AS gesamtpreis FROM  kauft AS ka INNER JOIN Produkt AS p ON p.Artikelnummer = ka.Artikelnummer WHERE ka.Rechnungsnummer = ?1", nativeQuery = true)
    List<Rechnungseintrag> getRechnungsliste(long Rechnungsnummer);

    @Query(value = "SELECT SUM(p.Preis*ka.Anzahl) AS totalpreis FROM Produkt AS p INNER JOIN kauft AS ka ON p.Artikelnummer = ka.Artikelnummer WHERE ka.Rechnungsnummer = ?1 GROUP BY ka.Rechnungsnummer", nativeQuery = true)
    List<Totalpreis> getTotalpreisVonRechnungsnummer(long Rechnungsnummer);
}
