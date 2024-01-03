package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import de.Rechnungen.Rechnungenbackend.Service.RechnungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/rechnung/")
public class RechnungController {
    private final RechnungService rechnungService;

    @Autowired
    public RechnungController(RechnungService rechnungService) {
        this.rechnungService = rechnungService;
    }


    @GetMapping(path = "{rechnungsnummer}")
    public @ResponseBody Rechnung getRechnungVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return rechnungService.getRechnungVonRechnungsnummer(rechnungsnummer);
    }


    @GetMapping()
    public @ResponseBody Iterable<Rechnung> getRechnungen(){
        return rechnungService.getRechnungen();
    }

    @PostMapping
    public void addRechnung(@RequestBody Rechnung rechnung){
        rechnungService.addRechnung(rechnung);
    }

    @DeleteMapping(path = "{rechnungsnummer}")
    public void deleteRechnungById(@PathVariable("rechnungsnummer") long rechnungsnummer){
        rechnungService.deleteRechnungById(rechnungsnummer);
    }
}
