package de.Rechnungen.Rechnungenbackend.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
