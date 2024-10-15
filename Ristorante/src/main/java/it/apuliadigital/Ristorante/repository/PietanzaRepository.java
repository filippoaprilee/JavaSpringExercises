package it.apuliadigital.Ristorante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.apuliadigital.Ristorante.entity.PietanzaEntity;

public interface PietanzaRepository extends JpaRepository<PietanzaEntity, Long> {
    // Aggiungi query personalizzate qui se necessario
}
