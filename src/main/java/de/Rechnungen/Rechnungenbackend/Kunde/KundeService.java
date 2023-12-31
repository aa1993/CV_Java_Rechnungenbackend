package de.Rechnungen.Rechnungenbackend.Kunde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.List;

@Service
public class KundeService {

    private final KundeRepository kundeRepository;

    @Autowired
    public KundeService(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    public Iterable<Kunde> getKunden(){
        return kundeRepository.findAll();
    }
}
