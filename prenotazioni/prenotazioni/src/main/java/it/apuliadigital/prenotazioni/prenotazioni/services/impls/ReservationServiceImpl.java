package it.apuliadigital.prenotazioni.prenotazioni.services.impls;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
        reservationDTO.setUserId(reservation.getUser().getId());
        reservationDTO.setTableType(reservation.getRestaurantTable().getTableType());
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

    public List<RestaurantTable> findAvailableTables(ReservationDTO reservationDTO) {
        LocalDate reservationDate = reservationDTO.getReservationDate();
        LocalTime reservationStartTime = reservationDTO.getReservationStartTime();
        LocalTime reservationEndTime = reservationStartTime.plusHours(2);

        List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
                .filter(r -> r.getReservationDate().equals(reservationDate))
                .filter(r -> r.getRestaurantTable().getSeats() == reservationDTO.getNumberOfGuests())
                .filter(r -> r.getReservationStartTime().isBefore(reservationEndTime) && r.getReservationEndTime().isAfter(reservationStartTime))
                .toList();

        List<RestaurantTable> allTables = tableRepository.findAll();

        List<RestaurantTable> availableTables = allTables.stream()
                .filter(t -> !overlappingReservations.stream()
                        .map(Reservation::getRestaurantTable)
                        .toList()
                        .contains(t))
                .toList();

        return availableTables;
    }

    public boolean isTableAvailable(RestaurantTable table, LocalDate reservationDate, LocalTime reservationStartTime, LocalTime reservationEndTime) {
        List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
                .filter(r -> r.getRestaurantTable().equals(table))
                .filter(r -> r.getReservationDate().equals(reservationDate))
                .filter(r -> r.getReservationStartTime().isBefore(reservationEndTime) && r.getReservationEndTime().isAfter(reservationStartTime))
                .toList();

        return overlappingReservations.isEmpty();
    }
}
