package it.apuliadigital.anagrafica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.apuliadigital.anagrafica.entity.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    // Aggiungi query personalizzate qui se necessario
}
