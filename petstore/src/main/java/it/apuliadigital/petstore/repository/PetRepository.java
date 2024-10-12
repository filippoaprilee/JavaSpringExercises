package it.apuliadigital.petstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.apuliadigital.petstore.entity.PetEntity;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {
    
}
