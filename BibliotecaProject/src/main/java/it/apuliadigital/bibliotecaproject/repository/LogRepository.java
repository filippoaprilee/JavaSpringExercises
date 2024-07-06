package it.apuliadigital.bibliotecaproject.repository;

import it.apuliadigital.bibliotecaproject.entity.LogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Long> {
}
