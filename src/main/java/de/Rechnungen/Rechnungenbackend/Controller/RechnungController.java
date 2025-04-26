package de.Rechnungen.Rechnungenbackend.Controller;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import de.Rechnungen.Rechnungenbackend.Json.EnthaeltJson;
import de.Rechnungen.Rechnungenbackend.Service.RechnungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/rechnungen")
public class RechnungController {
    private final RechnungService rechnungService;

    @Autowired
    public RechnungController(RechnungService rechnungService) {
        this.rechnungService = rechnungService;
    }

    @GetMapping()
    public @ResponseBody Iterable<Rechnung> getRechnungen(){
        return rechnungService.getRechnungen();
    }

    @GetMapping(path = "/{rechnungsnummer}")
    public @ResponseBody Rechnung getRechnungVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return rechnungService.getRechnungVonRechnungsnummer(rechnungsnummer);
    }

    @PostMapping
    public ResponseEntity<Rechnung> addRechnung(@RequestBody Rechnung rechnung){
        Rechnung rechnungErstellt = rechnungService.addRechnung(rechnung);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rechnungErstellt.getKundennummer())
                .toUri();

        return ResponseEntity.created(location).body(rechnungErstellt);
    }

    @DeleteMapping(path = "/{rechnungsnummer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRechnungById(@PathVariable("rechnungsnummer") long rechnungsnummer){
        rechnungService.deleteRechnungById(rechnungsnummer);
    }

    @PutMapping(path = "/{rechnungsnummer}")
    public @ResponseBody Rechnung setRechnungById(@PathVariable("rechnungsnummmer") long rechnungsnummer, @RequestBody Rechnung rechnung){
        return rechnungService.updateKundeById(rechnungsnummer, rechnung);
    }

    @GetMapping(path = "/{rechnungsnummer}/liste")
    public @ResponseBody Iterable<Rechnungseintrag> getRechnungseintragslisteVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnunsgnummer){
        return rechnungService.getRechnungseintrageVonRechnungsnummer(rechnunsgnummer);
    }

    @GetMapping(path = "/{rechnungsnummer}/liste/{artikelnummer}")
    public @ResponseBody Rechnungseintrag getRechnungseintragVonRechnungsnummerUndArtikelnummer(
            @PathVariable("rechnungsnummer") long rechnunsgnummer,
            @PathVariable("artikelnummer") long artikelnummer){
        return rechnungService.getRechnungseintragVonRechnungsnummerUndArtikelnummer(rechnunsgnummer, artikelnummer);
    }

    @PostMapping(path = "/{rechnungsnummer}/liste")
    public ResponseEntity<Rechnungseintrag> addRechnungseintrag(@PathVariable("rechnungsnummer") long rechnungsnummer, @RequestBody EnthaeltJson enthaeltJson){
        Rechnungseintrag rechnungseintrag = new Rechnungseintrag() {
            @Override
            public Long getArtikelnummer() {
                return enthaeltJson.getArtikelnummer();
            }

            @Override
            public String getProduktname() {
                return null;
            }

            @Override
            public Double getPreis() {
                return null;
            }

            @Override
            public Integer getAnzahl() {
                return enthaeltJson.getAnzahl();
            }

            @Override
            public Double getGesamtpreis() {
                return null;
            }
        };

        Rechnungseintrag rechnungseintragGefunden = rechnungService.addRechnungseintrag(rechnungsnummer, rechnungseintrag);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rechnungseintragGefunden.getArtikelnummer())
                .toUri();

        return ResponseEntity.created(location).body(rechnungseintragGefunden);
    }

    @DeleteMapping(path = "/{rechnungsnummer}/liste/{artikelnummer}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRechnungseintrag(@PathVariable("rechnungsnummer") long rechnunsgnummer, @PathVariable("artikelnummer") long artikelnummer){
        rechnungService.deleteRechnungseintrag(rechnunsgnummer, artikelnummer);
    }

    @PutMapping(path = "/{rechnungsnummer}/liste/{artikelnummer}")
    public @ResponseBody Rechnungseintrag updateRechnungseintrag(@PathVariable("rechnungsnummer") long rechnungsnummer,
                                                                 @PathVariable("artikelnummer") long artikelnummer,
                                                                 @RequestBody EnthaeltJson enthaeltJson){
        Rechnungseintrag rechnungseintrag = new Rechnungseintrag() {
            @Override
            public Long getArtikelnummer() {
                return artikelnummer;
            }

            @Override
            public String getProduktname() {
                return null;
            }

            @Override
            public Double getPreis() {
                return null;
            }

            @Override
            public Integer getAnzahl() {
                return enthaeltJson.getAnzahl();
            }

            @Override
            public Double getGesamtpreis() {
                return null;
            }
        };
        return rechnungService.updateRechnungseintrag(rechnungsnummer, artikelnummer, rechnungseintrag);
    }

    @GetMapping(path = "/{rechnungsnummer}/gesamtpreis")
    public @ResponseBody Totalpreis getTotalpreisVonRechnungsnummer(@PathVariable("rechnungsnummer") long rechnungsnummer){
        return rechnungService.getTotalpreisVonRechnungnummer(rechnungsnummer);
    }
}
