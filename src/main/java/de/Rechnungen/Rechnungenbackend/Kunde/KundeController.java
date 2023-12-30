package de.Rechnungen.Rechnungenbackend.Kunde;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/kunde")
public class KundeController {


    @GetMapping
    public List<Kunde> getKunden(){
        return List.of(
                new Kunde(
                        1L,
                        "Max",
                        "Mustermann",
                        "Musterstraße",
                        4,
                        11111,
                        "Musterstadt"
                )
        );
    }
}
