package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/kunde")
public class KundeController {

private final KundeService kundeService;

@Autowired
    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping
    public @ResponseBody Iterable<Kunde> getKunden(){
        return kundeService.getKunden();
    }

    @GetMapping(path = "/{kundennummer}")
    public @ResponseBody Kunde getKundeById(@PathVariable("kundennummer") long kundennummer){
        return kundeService.getKundeById(kundennummer);
    }

    /*
    @GetMapping(path = "/")
    public @ResponseBody Iterable<KundeKauftProduktInRechnung> getFullKunden(){
        return kundeService.getFullKunde();
    }
    */

}
