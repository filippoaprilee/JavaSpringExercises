package it.apuliadigital.Museo.repository;

import it.apuliadigital.Museo.entity.ArtistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long> {

}
