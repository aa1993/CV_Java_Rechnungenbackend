package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Service.RechnungslisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/totalpreis/")
public class TotalpreisController {
    private final RechnungslisteService rechnungslisteService;

    @Autowired
    public TotalpreisController(RechnungslisteService rechnungslisteService) {
        this.rechnungslisteService = rechnungslisteService;
    }

    @GetMapping(path = "{rechnungsnummer}")
    public Totalpreis getTotalpreisVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return rechnungslisteService.getTotalpreisVonRechnungnummer(rechnungsnummer);
    }
}
