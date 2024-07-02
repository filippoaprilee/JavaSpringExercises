package it.apuliadigital.conversioni.repository;

import it.apuliadigital.conversioni.entity.ConversionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionLogRepository extends JpaRepository<ConversionLog, Long> {
}
