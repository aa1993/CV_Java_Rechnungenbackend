package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;

    @Autowired
    public KundeService(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }


    public Iterable<Kunde> getKunden(){
        return kundeRepository.findAll();
    }

    public Kunde getKundeById(long kundennummer){
        Optional<Kunde> kundeOptional = kundeRepository.findById( kundennummer);
        if(kundeOptional.isPresent())
            return kundeOptional.get();
        throw new ResponseStatusException(NOT_FOUND, "Kein Kunde mit der Kundennummer " + kundennummer + " vorhanden!");
    }

    public Kunde addKunde(Kunde kunde){
        if(kunde.getKundennummer()!= null && kundeRepository.findById(kunde.getKundennummer()).isPresent())
            throw new ResponseStatusException(CONFLICT, "Kunde mit Kundennummmer " + kunde.getKundennummer()+" existiert bereits!");

        return kundeRepository.save(kunde);
    }

    public void deleteKunde(long kundennummer) {
        if(kundeRepository.existsById(kundennummer))
            kundeRepository.deleteById(kundennummer);
        else throw new ResponseStatusException(NOT_FOUND, "Kunde mit der Kundennummer "+ kundennummer+" ist nicht vorhanden.");
    }

    public Kunde updateKundeById(long kundennummer, Kunde kunde){
        Optional<Kunde> kundeOptional = kundeRepository.findById(kundennummer);
        if(!kundeOptional.isPresent())
            throw new ResponseStatusException(NOT_FOUND, "Kein Kunde mit der Kundennummer " + kundennummer + " vorhanden!");
        Kunde internKunde = kundeOptional.get();
        if(kunde.getHausnummer() != null) internKunde.setHausnummer(kunde.getHausnummer());
        if(kunde.getPLZ() != null) internKunde.setPLZ(kunde.getPLZ());
        if(kunde.getOrt() != null) internKunde.setOrt(kunde.getOrt());
        if(kunde.getStrasse() != null) internKunde.setStrasse(kunde.getStrasse());
        if(kunde.getVorname() != null) internKunde.setVorname(kunde.getVorname());
        if(kunde.getNachname() != null) internKunde.setNachname(kunde.getNachname());
        kundeRepository.save(internKunde);
        return internKunde;
    }
}
