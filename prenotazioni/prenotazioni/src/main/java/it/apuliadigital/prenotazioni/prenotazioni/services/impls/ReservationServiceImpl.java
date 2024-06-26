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

        RestaurantTable freeTable = freeTable(reservationDTO, reservation.getReservationDate(),
                reservation.getReservationStartTime(), reservation.getReservationEndTime());

        reservation.setRestaurantTable(freeTable);
        reservation.setUser(userRepository.findById(reservationDTO.getUserId()).get());
        return reservation;
    }

    public RestaurantTable freeTable(ReservationDTO reservationDTO, LocalDate reservationDate,
                                     LocalTime reservationStartTime, LocalTime reservationEndTime) {

        // Lista di TAVOLI che soddisfano le richieste numero di invitati e tipologia
        List<RestaurantTable> elegibleTables = tableRepository.findAll()
                .stream()
                .filter(x -> x.getSeats() == reservationDTO.getNumberOfGuests()
                        && x.getTableType() == reservationDTO.getTableType())
                .toList();

        /*
         * Lista di ID di tavoli occupati nella data della prenotazione con
         * orari che vanno in conflitto con la prenotazione
         */
        List<Long> occupiedTablesID = reservationRepository.findAll()
                .stream()
                .filter(x -> x.getReservationDate().compareTo(reservationDate) == 0
                        && (reservationStartTime.compareTo(x.getReservationEndTime()) != 1
                        || reservationEndTime.compareTo(x.getReservationStartTime()) != -1))
                .map(x -> x.getRestaurantTable().getId())
                .toList();

        /*
         * Rimuovo dalla lista di tavoli possibili quelli i cui id sono presenti nella
         * lista di ID di tavoli occupati
         */
        elegibleTables.removeIf(x -> occupiedTablesID.contains(x.getId()));

        RestaurantTable freeTable = elegibleTables.get(0);

        return freeTable;
    }
}
