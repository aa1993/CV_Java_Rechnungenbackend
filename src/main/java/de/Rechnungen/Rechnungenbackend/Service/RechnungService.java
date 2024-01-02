package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Repository.RechnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
        throw new NoSuchElementException("Kein Rechnung mit der Rechnngsnnummer " + rechnungsnummer + " vorhanden!");
    }
}
