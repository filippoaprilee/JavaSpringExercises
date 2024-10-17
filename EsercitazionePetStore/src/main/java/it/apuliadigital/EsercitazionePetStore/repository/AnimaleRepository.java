package it.apuliadigital.EsercitazionePetStore.repository;

import it.apuliadigital.EsercitazionePetStore.entity.AnimaleEntity;
import it.apuliadigital.EsercitazionePetStore.server.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaleRepository extends JpaRepository<AnimaleEntity, Long> {
}
