package it.apuliadigital.gestioneristorante.repositories;

import it.apuliadigital.gestioneristorante.entities.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiningTableRepository extends JpaRepository<DiningTable, Long> {
}
