package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Entity.Produkt;
import de.Rechnungen.Rechnungenbackend.Repository.ProduktRepository;
import io.micrometer.observation.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

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
        throw new ResponseStatusException(NOT_FOUND, "Produkt mit der Artikelnummer " + artikelnummer + " nicht vorhanden!");
    }

    public Produkt addProdukt(Produkt produkt) {
        if(produkt.getArtikelnummer() != null && produktRepository.findById(produkt.getArtikelnummer()).isPresent())
            throw new ResponseStatusException(CONFLICT, "Produkt mit Artikelnummmer " + produkt.getArtikelnummer()+" existiert bereits!");
        if(produkt.getProduktname()==null || produkt.getPreis()==null){
            throw new ResponseStatusException(BAD_REQUEST, "Es müssen alle Angaben für das Produkt angeben werden.");
        }
        return produktRepository.save(produkt);

    }

    public void deleteProduktById(long artikelnummer) {
        if(produktRepository.existsById(artikelnummer))
            produktRepository.deleteById(artikelnummer);
        else
            throw new ResponseStatusException(NOT_FOUND, "Produkt mit der Atrikelnummer "+artikelnummer+" ist nicht vorhanden!");
    }

    public Produkt updateProdukt(long artikelnummer, Produkt produkt){
        Optional<Produkt> produktOptional = produktRepository.findById(artikelnummer);
        if(produktOptional.isEmpty())
            throw new ResponseStatusException(NOT_FOUND, "Kein Produkt mit der Artikelnummer " + artikelnummer + " vorhanden!");
        Produkt internKunde = produktOptional.get();
        if(produkt.getProduktname() != null) internKunde.setProduktname(produkt.getProduktname());
        if(produkt.getPreis() != null) internKunde.setPreis(produkt.getPreis());
        produktRepository.save(internKunde);
        return internKunde;
    }
}
