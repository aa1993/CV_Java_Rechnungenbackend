package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Rechnung;
import org.springframework.data.repository.CrudRepository;

public interface RechnungRepository extends CrudRepository<Rechnung, Long> {
}
