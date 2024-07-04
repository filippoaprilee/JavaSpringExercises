package it.apuliadigital.rubricaprojectpro.repository;

import it.apuliadigital.rubricaprojectpro.entity.ContattoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends CrudRepository<ContattoEntity, Integer> {
}