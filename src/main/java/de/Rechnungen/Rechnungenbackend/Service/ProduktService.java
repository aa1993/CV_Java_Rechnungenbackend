package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Produkt;
import de.Rechnungen.Rechnungenbackend.Repository.ProduktRepository;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProduktService {
    private final ProduktRepository produktRepository;

    @Autowired
    public ProduktService(ProduktRepository produktRepository) {
        this.produktRepository = produktRepository;
    }


    public Iterable<Produkt> getProdukte(){
        return produktRepository.findAll();
    }

    public Produkt getProduktVonArtikelnummer(long artikelnummer){
        Optional<Produkt> produktOptional = produktRepository.findById(artikelnummer);
        if(produktOptional.isPresent())
            return produktOptional.get();
        throw new NoSuchElementException("Produkt mit der Artikelnummer " + artikelnummer + " nicht vorhanden!");
    }
}
