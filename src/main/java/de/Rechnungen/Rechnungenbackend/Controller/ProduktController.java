package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Produkt;
import de.Rechnungen.Rechnungenbackend.Service.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/produkt")
public class ProduktController {

    private final ProduktService produktService;

    @Autowired
    public ProduktController(ProduktService produktService) {
        this.produktService = produktService;
    }

    @GetMapping
    public Iterable<Produkt> getProdukte(){
        return produktService.getProdukte();
    }

    @GetMapping(path = "/{artikelnummer}")
    public Produkt getProduktVonArtikelnummer(@PathVariable("artikelnummer") long artikelnummer) {
        return produktService.getProduktVonArtikelnummer(artikelnummer);
    }

    @PostMapping
    public ResponseEntity<Produkt> addProdukt(@RequestBody Produkt produkt){
        Produkt produktGefunden = produktService.addProdukt(produkt);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produktGefunden.getArtikelnummer())
                .toUri();

        return ResponseEntity.created(location).body(produktGefunden);
    }

    @DeleteMapping(path = "/{artikelnummer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduktById(@PathVariable("artikelnummer") long artikelnummer){
        produktService.deleteProduktById(artikelnummer);
    }

    @PutMapping(path = "/{artikelnummer}")
    public @ResponseBody Produkt updateProdukt(@PathVariable("artikelnummer") long artikelnummer,
                                               @RequestBody Produkt produkt){
        return produktService.updateProdukt(artikelnummer, produkt);
    }
}