package it.apuliadigital.prenotazioni.prenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.apuliadigital.prenotazioni.prenotazioni.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
