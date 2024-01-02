package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Produkt;
import de.Rechnungen.Rechnungenbackend.Service.ProduktService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/produkt/")
public class ProduktController {

    private final ProduktService produktService;

    public ProduktController(ProduktService produktService) {
        this.produktService = produktService;
    }

    @GetMapping
    public Iterable<Produkt> getProdukte(){
        return produktService.getProdukte();
    }

    @GetMapping(path = "{artikelnummer}")
    public Produkt getProduktVonArtikelnummer(@PathVariable("artikelnummer") long artikelnummer){
        return produktService.getProduktVonArtikelnummer(artikelnummer);
    }
}
