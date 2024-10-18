package it.its.formazione.springboot.esercizio2.filippo_aprile.repository;

import it.its.formazione.springboot.esercizio2.filippo_aprile.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
    // Rimosso il metodo esistente perchè ora utilizziamo il metodo existsByRoomNumberAndCheckInDate
    boolean existsByRoomNumberAndCheckInDate(Integer roomNumber, String checkInDate);

    List<BookingEntity> findByRoomNumber(Integer roomNumber);
}
