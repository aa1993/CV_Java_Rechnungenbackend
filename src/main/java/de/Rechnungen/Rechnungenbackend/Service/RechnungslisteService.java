package de.Rechnungen.Rechnungenbackend.Service;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.Rechnungseintrag;
import de.Rechnungen.Rechnungenbackend.Entity.Custom.Totalpreis;
import de.Rechnungen.Rechnungenbackend.Repository.CustomQueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RechnungslisteService {
    private final CustomQueryRepo customQueryRepo;

    @Autowired
    public RechnungslisteService(CustomQueryRepo customQueryRepo) {
        this.customQueryRepo = customQueryRepo;
    }


    public Iterable<Rechnungseintrag> getRechnungseintrageVonRechnungsnummer(long rechnungsnummer){
        return customQueryRepo.getRechnungsliste(rechnungsnummer);
    }

    public Totalpreis getTotalpreisVonRechnungnummer(long rechnungsnummer){
        if(!customQueryRepo.getTotalpreisVonRechnungsnummer(rechnungsnummer).isEmpty())
            return customQueryRepo.getTotalpreisVonRechnungsnummer(rechnungsnummer).getFirst();
        throw new NoSuchElementException("Rechnung mit Rechnungsnummer " + rechnungsnummer + " nicht vorhanden!");
    }
}
