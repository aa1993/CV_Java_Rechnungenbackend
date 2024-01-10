package de.Rechnungen.Rechnungenbackend.Repository;

import de.Rechnungen.Rechnungenbackend.Entity.Custom.EnthaeltVanillia;
import de.Rechnungen.Rechnungenbackend.Entity.Enthaelt;
import de.Rechnungen.Rechnungenbackend.Entity.EnthaeltId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnthaeltRepository extends CrudRepository<Enthaelt, EnthaeltId> {

    @Query(value = "select * from enthaelt", nativeQuery = true)
    List<EnthaeltVanillia> getEnthaeltVanillia();
}
