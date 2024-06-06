package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Repository.RechnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class RechnungService {
    private final RechnungRepository rechnungRepository;

    @Autowired
    public RechnungService(RechnungRepository rechnungRepository) {
        this.rechnungRepository = rechnungRepository;
    }

    public Iterable<Rechnung> getRechnungen(){
        return rechnungRepository.findAll();
    }

    public Rechnung getRechnungVonRechnungsnummer(long rechnungsnummer){
        Optional<Rechnung> rechnungOptional = rechnungRepository.findById(rechnungsnummer);
        if(rechnungOptional.isPresent())
            return rechnungOptional.get();
        throw new ResponseStatusException(NOT_FOUND, "Kein Rechnung mit der Rechnungsnummer " + rechnungsnummer + " vorhanden!");
    }

    public Rechnung addRechnung(Rechnung rechnung) {
        if(rechnung.getRechnungsnummer()!=null && rechnungRepository.findById(rechnung.getRechnungsnummer()).isPresent())
            throw  new ResponseStatusException(HttpStatus.CONFLICT, "Rechnung mit Rechnungsnummer " + rechnung.getRechnungsnummer() + " existiert bereits!");
        if(rechnung.getKundennummer()==null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Die Kundennummer muss angegeben werden");
        if(rechnung.getRechnungsdatum()==null)
            rechnung.setRechnungsdatum(LocalDate.now());
        return rechnungRepository.save(rechnung);
    }

    public void deleteRechnungById(long rechnungsnummer) {
        if(rechnungRepository.existsById(rechnungsnummer))
            rechnungRepository.deleteById(rechnungsnummer);
        throw new ResponseStatusException(NOT_FOUND, "Kein Rechnung mit der Rechnungsnummer " + rechnungsnummer + " vorhanden!");
    }

    public Rechnung updateKundeById(long rechnungsnummer, Rechnung rechnung) {
        Optional<Rechnung> rechnungOptional = rechnungRepository.findById(rechnungsnummer);

        if(!rechnungOptional.isPresent())
            throw new ResponseStatusException(NOT_FOUND, "Kein Rechnung mit der Rechnungsnummer " + rechnungsnummer + " vorhanden!");
        Rechnung rechnungGefunden = rechnungOptional.get();
        if(rechnung.getKundennummer() != null) rechnungGefunden.setKundennummer(rechnung.getKundennummer());
        if(rechnung.getRechnungsdatum() != null) rechnungGefunden.setRechnungsdatum(rechnung.getRechnungsdatum());
        rechnungRepository.save(rechnungGefunden);
        return rechnungGefunden;
    }

    public Iterable<Rechnungseintrag> getRechnungseintrageVonRechnungsnummer(long rechnungsnummer){
        return rechnungRepository.getRechnungsliste(rechnungsnummer);
    }

    public Totalpreis getTotalpreisVonRechnungnummer(long rechnungsnummer){
        if(!rechnungRepository.getTotalpreisVonRechnungsnummer(rechnungsnummer).isEmpty())
            return rechnungRepository.getTotalpreisVonRechnungsnummer(rechnungsnummer).getFirst();
        throw new NoSuchElementException("Rechnung mit Rechnungsnummer " + rechnungsnummer + " nicht vorhanden!");
    }

    public Rechnungseintrag getRechnungseintragVonRechnungsnummerUndArtikelnummer(long rechnunsgnummer, long artikelnummer) {
        Optional<Rechnungseintrag> optionalRechnungseintrag = rechnungRepository.getRechnungseintrag(rechnunsgnummer, artikelnummer);
        if(optionalRechnungseintrag.isEmpty())
            throw new ResponseStatusException(NOT_FOUND, "Das Produkt mit der Artikelnummer "+ artikelnummer+" ist in der Rechnung " +rechnunsgnummer+" nicht vorhanden.");
        return optionalRechnungseintrag.get();
    }

    @Transactional
    public Rechnungseintrag addRechnungseintrag(long rechnungsnummer, Rechnungseintrag rechnungseintrag) {
        if(rechnungseintrag.getArtikelnummer()!= null && rechnungRepository.getRechnungseintrag(rechnungsnummer, rechnungseintrag.getArtikelnummer()).isPresent())
            throw new ResponseStatusException(CONFLICT, "Produkt mit Artikelnummer " + rechnungseintrag.getArtikelnummer()+" ist in der Rechnung mit Rechnungsnummer "+rechnungsnummer+" bereits vorhanden!");
        if(rechnungseintrag.getAnzahl()==null || rechnungseintrag.getArtikelnummer()==null){
            throw new ResponseStatusException(BAD_REQUEST, "Es müssen die Angabe der Anzahl und Artikelnummer angeben werden.");
        }
        rechnungRepository.addRechnungseintrag(rechnungsnummer, rechnungseintrag.getArtikelnummer(), rechnungseintrag.getAnzahl());
        return rechnungRepository.getRechnungseintrag(rechnungsnummer, rechnungseintrag.getArtikelnummer()).get();
    }

    @Transactional
    public void deleteRechnungseintrag(long rechnungsnummer, long artikelnummer) {
        if(rechnungRepository.getRechnungseintrag(rechnungsnummer, artikelnummer).isPresent())
            rechnungRepository.deleteRechnungseintrag(rechnungsnummer, artikelnummer);
        else throw new ResponseStatusException(NOT_FOUND, "Das Produkt mit der Artikelnummer "+ artikelnummer+" ist in der Rechnung " +rechnungsnummer+" nicht vorhanden.");
    }

    @Transactional
    public Rechnungseintrag updateRechnungseintrag(long rechnungsnummer, long artikelnummer, Rechnungseintrag rechnungseintrag) {
        Optional<Rechnungseintrag> rechnungseintragOptional = rechnungRepository.getRechnungseintrag(rechnungsnummer, artikelnummer);
        if(rechnungseintragOptional.isEmpty())
            throw new ResponseStatusException(NOT_FOUND, "Das Produkt mit der Artikelnummer "+ artikelnummer+" ist in der Rechnung " +rechnungsnummer+" nicht vorhanden.");
        if(rechnungseintrag.getAnzahl() != null)
            rechnungRepository.updateRechnungseintrag(rechnungsnummer, artikelnummer, rechnungseintrag.getAnzahl());
        return rechnungRepository.getRechnungseintrag(rechnungsnummer, artikelnummer).get();
    }
}
