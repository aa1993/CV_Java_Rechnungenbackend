package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rechnung/")
public class RechnungController {
    private final KundeService kundeService;

    @Autowired

    public RechnungController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping(path = "{rechnungsnummer}")
    public @ResponseBody Rechnung getRechnungVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return kundeService.getRechnungVonRechnungsnummer(rechnungsnummer);
    }


    @GetMapping()
    public @ResponseBody Iterable<Rechnung> getRechnungen(){
        return kundeService.getRechnungen();
    }
}
