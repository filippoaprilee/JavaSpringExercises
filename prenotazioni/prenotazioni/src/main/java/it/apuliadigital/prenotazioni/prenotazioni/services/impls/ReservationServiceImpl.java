package it.apuliadigital.prenotazioni.prenotazioni.services.impls;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.prenotazioni.prenotazioni.entities.Reservation;
import it.apuliadigital.prenotazioni.prenotazioni.entities.RestaurantTable;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.ReservationDTO;
import it.apuliadigital.prenotazioni.prenotazioni.repositories.ReservationRepository;
import it.apuliadigital.prenotazioni.prenotazioni.repositories.RestaurantTableRepository;
import it.apuliadigital.prenotazioni.prenotazioni.repositories.UserRepository;
import it.apuliadigital.prenotazioni.prenotazioni.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RestaurantTableRepository tableRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) {
        try {
            Reservation reservation = fromDTOToReservation(reservationDTO, new Reservation());
            reservationRepository.save(reservation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeReservation(long id) {
        try {
            reservationRepository.findById(id).get(); // risolto ma bruttino
            reservationRepository.deleteById(id); // TODO torna sempre true perchè ignora se non trova l'entità
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ReservationDTO getReservation(long id) {
        try {
            return fromReservationToDTO(reservationRepository.findById(id).get(), new ReservationDTO());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ReservationDTO> getReservations() {
        try {
            List<Reservation> listReservations = reservationRepository.findAll();
            List<ReservationDTO> listReservationsDTO = new ArrayList<ReservationDTO>();
            for (Reservation x : listReservations) {
                listReservationsDTO.add(fromReservationToDTO(x, new ReservationDTO()));
            }
            return listReservationsDTO;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean updateReservation(long id, ReservationDTO reservationDTO) {
        try {
            // TODO complesso?
            // Optional<Reservation> optReservation = reservationRepository.findById(id);
            // Reservation reservation = optReservation.get()
            // reservation = fromDTOtoReservation(reservationDTO, reservation);
            // reservationRepository.save(reservation);
            reservationRepository.save(fromDTOToReservation(reservationDTO, reservationRepository.findById(id).get()));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ReservationDTO fromReservationToDTO(Reservation reservation, ReservationDTO reservationDTO) {
        reservationDTO.setNumberOfGuests(reservation.getRestaurantTable().getSeats());
        reservationDTO.setReservationDate(reservation.getReservationDate());
        reservationDTO.setReservationStartTime(reservation.getReservationStartTime());
        return reservationDTO;
    }

    @Override
    public Reservation fromDTOToReservation(ReservationDTO reservationDTO, Reservation reservation) {

        reservation.setReservationDate(reservationDTO.getReservationDate());
        reservation.setReservationStartTime(reservationDTO.getReservationStartTime());
        reservation.setReservationEndTime(reservationDTO.getReservationStartTime().plusHours(2));

        List<RestaurantTable> elegibleTables = elegibleTables(reservationDTO);

        RestaurantTable freeTable = freeTable(elegibleTables, reservation.getReservationDate(),
                reservation.getReservationStartTime(), reservation.getReservationEndTime());

        reservation.setRestaurantTable(freeTable);
        reservation.setUser(userRepository.findById(reservationDTO.getUserId()).get());
        return reservation;
    }

    public List<RestaurantTable> elegibleTables(ReservationDTO reservationDTO) {

        List<RestaurantTable> elegibleTables = tableRepository.findAll().stream()
                .filter(x -> x.getSeats() == reservationDTO.getNumberOfGuests()
                        && x.getTableType() == reservationDTO.getTableType())
                .toList();

        return elegibleTables;
    }

    public RestaurantTable freeTable(List<RestaurantTable> elegibleTables, LocalDate reservationDate,
                                     LocalTime reservationStartTime, LocalTime reservationEndTime) {

        // Cerca il primo tavolo elegibile che sia libero durante l'intervallo richiesto
        return elegibleTables.stream()
                .filter(table -> reservationRepository.findAll().stream()
                        .noneMatch(reservation ->
                                reservation.getRestaurantTable().getId() == table.getId() &&
                                        reservation.getReservationDate().equals(reservationDate) &&
                                        ((reservationStartTime.isAfter(reservation.getReservationStartTime()) && reservationStartTime.isBefore(reservation.getReservationEndTime())) ||
                                                (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservationEndTime.isBefore(reservation.getReservationEndTime())))
                        )
                )
                .findFirst()
                .orElse(null); // Ritorna null se non trova un tavolo libero
    }
}
