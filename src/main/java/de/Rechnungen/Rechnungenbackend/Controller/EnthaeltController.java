package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.EnthaeltVanillia;
import de.Rechnungen.Rechnungenbackend.Entity.Enthaelt;
import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Exceptions.EntityAlreadyExistsException;
import de.Rechnungen.Rechnungenbackend.Exceptions.NotMatchingArgumentException;
import de.Rechnungen.Rechnungenbackend.Json.EnthaeltJson;
import de.Rechnungen.Rechnungenbackend.Service.EnthaeltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.management.openmbean.KeyAlreadyExistsException;

@RestController
@RequestMapping(path = "/api/v1/enthaelt/")
public class EnthaeltController {

    private final EnthaeltService enthaeltService;

    @Autowired
    public EnthaeltController(EnthaeltService enthaeltService) {
        this.enthaeltService = enthaeltService;
    }

    @GetMapping
    public @ResponseBody Iterable<EnthaeltVanillia> getEnthaelt(){
        return enthaeltService.getEnthaelt();
    }

    @PostMapping
    public void addKunde(@RequestBody EnthaeltJson enthaeltJson){
        try {
            enthaeltService.addEnthaelt(enthaeltJson);
        } catch (NotMatchingArgumentException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        } catch (EntityAlreadyExistsException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Das Produkt mit der Artikelnummer " + enthaeltJson.getArtikelnummer() +
                        " ist bereits in der Rechnung mit der Rechnungsnummer " + enthaeltJson.getRechnungsnummer() + " enthalten", e);

        }
    }
}
