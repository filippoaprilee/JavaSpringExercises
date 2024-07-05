package it.apuliadigital.rubricaprojectpro.repository;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContattoRepository extends CrudRepository<ContattoEntity, Integer> {
    List<ContattoEntity> findByNomeAndCognome(String nome, String cognome);
}