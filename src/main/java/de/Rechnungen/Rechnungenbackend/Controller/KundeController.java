package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import de.Rechnungen.Rechnungenbackend.Service.KundeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/kunden")
public class KundeController {

private final KundeService kundeService;

@Autowired
    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping
    public @ResponseBody Iterable<Kunde> getKunden(){
        Iterable<Kunde> iter = kundeService.getKunden();
        for(Kunde k : iter){
            k.setOrt(k.getOrt().replace("Ã¶", "ö")
                    .replace("Ã¤", "ä")
                    .replace("Ã¼", "ü")
                    .replace("ÃŸ", "ß"));
            System.out.println(k.toString());

        }
        return iter;
    }

    @GetMapping(path = "/{kundennummer}")
    public @ResponseBody Kunde getKundeById(@PathVariable("kundennummer") long kundennummer){
        return kundeService.getKundeById(kundennummer);
    }

    @PostMapping
    public ResponseEntity<Kunde> addKunde(@RequestBody Kunde kunde){
        Kunde kundeGefunden = kundeService.addKunde(kunde);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(kundeGefunden.getKundennummer())
                .toUri();

        return ResponseEntity.created(location).body(kundeGefunden);
    }

    @DeleteMapping(path = "/{kundennummer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKunde(@PathVariable("kundennummer") long kundennummer){
        kundeService.deleteKunde(kundennummer);
    }

    @PutMapping(path ="/{kundennummer}")
    public @ResponseBody Kunde setKundeById(@PathVariable("kundennummer") long kundennummer, @RequestBody Kunde kunde){
        return kundeService.updateKundeById(kundennummer, kunde);
    }

}
