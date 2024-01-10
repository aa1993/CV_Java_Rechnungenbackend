package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.EnthaeltVanillia;
import de.Rechnungen.Rechnungenbackend.Entity.Enthaelt;
import de.Rechnungen.Rechnungenbackend.Entity.EnthaeltId;
import de.Rechnungen.Rechnungenbackend.Exceptions.EntityAlreadyExistsException;
import de.Rechnungen.Rechnungenbackend.Exceptions.NotMatchingArgumentException;
import de.Rechnungen.Rechnungenbackend.Json.EnthaeltJson;
import de.Rechnungen.Rechnungenbackend.Repository.EnthaeltRepository;
import de.Rechnungen.Rechnungenbackend.Repository.ProduktRepository;
import de.Rechnungen.Rechnungenbackend.Repository.RechnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
public class EnthaeltService {

    private final EnthaeltRepository enthaeltRepository;
    private final ProduktRepository produktRepository;
    private final RechnungRepository rechnungRepository;

    @Autowired
    public EnthaeltService(EnthaeltRepository enthaeltRepository, ProduktRepository produktRepository, RechnungRepository rechnungRepository) {
        this.enthaeltRepository = enthaeltRepository;
        this.produktRepository = produktRepository;
        this.rechnungRepository = rechnungRepository;
    }

    public Iterable<EnthaeltVanillia> getEnthaelt(){
        return enthaeltRepository.getEnthaeltVanillia();
    }

    public void addEnthaelt(EnthaeltJson enthaeltJson) throws NotMatchingArgumentException, EntityAlreadyExistsException {
        if(produktRepository.existsById(enthaeltJson.getArtikelnummer()) ){
            if(rechnungRepository.existsById(enthaeltJson.getRechnungsnummer())){
                if(enthaeltJson.getAnzahl()> 0){
                    EnthaeltId id = new EnthaeltId(enthaeltJson.getRechnungsnummer(), enthaeltJson.getArtikelnummer());
                    if(!enthaeltRepository.existsById(id)) {
                        Enthaelt enthaelt = new Enthaelt(id, enthaeltJson.getAnzahl());
                        enthaeltRepository.save(enthaelt);
                    } else {
                        throw new EntityAlreadyExistsException();
                    }
                } else {
                    throw new NotMatchingArgumentException("Die Anzahl muss größer als 0 sein");
                }
            } else {
                throw new NotMatchingArgumentException("Keine Rechnung mit der Rechnungsnummer "+enthaeltJson.getRechnungsnummer()+" vorhanden");
            }
        } else {
            throw new NotMatchingArgumentException("Keine Produkt mit der Artikelnummer "+enthaeltJson.getArtikelnummer()+" vorhanden");
        }
    }
}
