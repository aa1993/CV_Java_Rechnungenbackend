package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rechnungsliste/")
public class RechnungslisteController {
    private final KundeService kundeService;

    @Autowired
    public RechnungslisteController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping(path = "{rechnungsnummer}")
    public @ResponseBody Iterable<Rechnungseintrag> getRechnungseintrageVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return kundeService.getRechnungseintrageVonRechnungsnummer(rechnungsnummer);
    }
}
