package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Repository.CustomQueryRepo;
import de.Rechnungen.Rechnungenbackend.Repository.KundeRepository;
import de.Rechnungen.Rechnungenbackend.Repository.RechnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;
    private final CustomQueryRepo customQueryRepo;
    private final RechnungRepository rechnungRepository;

    @Autowired
    public KundeService(KundeRepository kundeRepository, CustomQueryRepo customQueryRepo, RechnungRepository rechnungRepository) {
        this.kundeRepository = kundeRepository;
        this.customQueryRepo = customQueryRepo;
        this.rechnungRepository = rechnungRepository;
    }

    public Iterable<Kunde> getKunden(){
        return kundeRepository.findAll();
    }

    public Kunde getKundeById(long kundennummer){
        Optional<Kunde> kundeOptional = kundeRepository.findById( kundennummer);
        if(kundeOptional.isPresent())
            return kundeOptional.get();
        throw new NoSuchElementException("Kein Kunde mit der Kundennummer " + kundennummer + " vorhanden!");
    }

    public Iterable<Rechnung> getRechnungen(){
        return rechnungRepository.findAll();
    }

    public Rechnung getRechnungVonRechnungsnummer(long rechnungsnummer){
        Optional<Rechnung> rechnungOptional = rechnungRepository.findById(rechnungsnummer);
        if(rechnungOptional.isPresent())
            return rechnungOptional.get();
        throw new NoSuchElementException("Kein Rechnung mit der Rechnngsnnummer " + rechnungsnummer + " vorhanden!");
    }
}
