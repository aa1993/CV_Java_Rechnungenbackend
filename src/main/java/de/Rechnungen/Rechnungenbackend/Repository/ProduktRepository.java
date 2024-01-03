package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Produkt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProduktRepository extends CrudRepository<Produkt,Long> {

    @Query(value = "SELECT * FROM Produkt AS p where p.Produktname=?1", nativeQuery = true)
    Optional<Produkt> findProduktByName(String produktname);
}
