package it.apuliadigital.prenotazioni.prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.apuliadigital.prenotazioni.prenotazioni.entities.RestaurantTable;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    // RestaurantTable findFirstBySeatsAndType(int seats, String tableType);
}
