package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.KundeKauftProduktInRechnung;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomQueryRepo extends JpaRepository<Rechnung, Long> {
    @Query(value = "SELECT k.Kundennummer AS kundennummer, k.Vorname AS vorname, k.Nachname AS nachname, k.Strasse AS strasse, k.Hausnummer AS hausnummer, k.PLZ AS plz, k.Ort as ort, r.Rechnungsnummer AS rechnungsnummer, p.Artikelnummer AS artikelnummer, ka.Anzahl as anzahl FROM Produkt AS p Inner JOIN kauft AS ka Inner JOIN Kunde AS k Inner JOIN Rechnung AS r on p.Artikelnummer=ka.Artikelnummer and k.Kundennummer=ka.Kundennummer and r.Rechnungsnummer=ka.Rechnungsnummer", nativeQuery = true)
    List<KundeKauftProduktInRechnung> getKundeKauftProduktInRechnung();

    @Query(value = "SELECT p.Artikelnummer AS artikelnummer, p.Produktname AS produktname, p.Preis AS preis, ka.Anzahl AS anzahl FROM  kauft AS ka INNER JOIN Produkt AS p ON p.Artikelnummer = ka.Artikelnummer WHERE ka.Rechnungsnummer = ?1", nativeQuery = true)
        List<Rechnungseintrag> getRechnungsliste(long RechnungsId);
}
