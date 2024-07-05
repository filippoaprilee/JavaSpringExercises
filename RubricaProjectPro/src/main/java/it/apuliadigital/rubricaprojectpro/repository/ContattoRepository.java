package it.apuliadigital.rubricaprojectpro.repository;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    * DOC: https://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 */

@Repository
public interface ContattoRepository extends CrudRepository<ContattoEntity, Integer> {
    List<ContattoEntity> findByNomeAndCognome(String nome, String cognome);
}