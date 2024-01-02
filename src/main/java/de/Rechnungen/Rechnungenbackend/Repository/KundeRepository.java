package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Kunde;
import org.springframework.data.repository.CrudRepository;

public interface KundeRepository extends CrudRepository<Kunde, Long> {
}
