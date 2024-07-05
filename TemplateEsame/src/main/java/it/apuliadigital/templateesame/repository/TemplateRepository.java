package it.apuliadigital.templateesame.repository;

import it.apuliadigital.templateesame.entity.TemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<TemplateEntity, Integer>{
    // DOCUMENTAZIONE: https://docs.spring.io/spring-data/jpa/docs/1.5.1.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
}
