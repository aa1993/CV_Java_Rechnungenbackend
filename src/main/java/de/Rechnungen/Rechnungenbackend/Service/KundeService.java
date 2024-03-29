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
        throw new NoSuchElementException("Kein Kunde mit der Kundennummer " + kundennummer + " vorhanden!");
    }

    public void addKunde(Kunde kunde){
        kundeRepository.save(kunde);
    }

    public void deleteKunde(long kundennummer) {
        if(kundeRepository.existsById(kundennummer))
            kundeRepository.deleteById(kundennummer);
        else throw new NoSuchElementException("Kunde mit der Kundennummer "+ kundennummer+" ist nicht vorhanden.");
    }
}
