package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Repository.CustomQueryRepo;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import de.Rechnungen.Rechnungenbackend.Service.RechnungslisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rechnungsliste/")
public class RechnungslisteController {
    private final RechnungslisteService rechnungslisteService;

    @Autowired
    public RechnungslisteController(RechnungslisteService rechnungslisteService) {
        this.rechnungslisteService = rechnungslisteService;
    }



    @GetMapping(path = "{rechnungsnummer}")
    public @ResponseBody Iterable<Rechnungseintrag> getRechnungseintrageVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return rechnungslisteService.getRechnungseintrageVonRechnungsnummer(rechnungsnummer);
    }
}
