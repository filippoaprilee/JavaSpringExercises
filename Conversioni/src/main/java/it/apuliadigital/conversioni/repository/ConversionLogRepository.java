package it.apuliadigital.conversioni.repository;

import it.apuliadigital.conversioni.entity.ConversionLog;
import org.springframework.data.repository.CrudRepository;

public interface ConversionLogRepository extends CrudRepository<ConversionLog, Long>{
}
