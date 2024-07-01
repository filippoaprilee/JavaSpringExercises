import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

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
            logger.info("Prenotazione aggiunta con successo: {}", reservation.getId());
            return true;
        } catch (Exception e) {
            logger.error("Errore durante l'aggiunta della prenotazione", e);
            return false;
        }
    }

    @Override
    public boolean removeReservation(long id) {
        try {
            reservationRepository.deleteById(id);
            logger.info("Prenotazione con ID {} rimossa con successo", id);
            return true;
        } catch (Exception e) {
            logger.error("Errore durante la rimozione della prenotazione con ID {}", id, e);
            return false;
        }
    }

    @Override
    public ReservationDTO getReservation(long id) {
        try {
            return fromReservationToDTO(reservationRepository.findById(id).orElse(null), new ReservationDTO());
        } catch (Exception e) {
            logger.error("Errore durante il recupero della prenotazione con ID {}", id, e);
            return null;
        }
    }

    @Override
    public List<ReservationDTO> getReservations() {
        try {
            List<Reservation> listReservations = reservationRepository.findAll();
            List<ReservationDTO> listReservationsDTO = new ArrayList<>();
            for (Reservation reservation : listReservations) {
                listReservationsDTO.add(fromReservationToDTO(reservation, new ReservationDTO()));
            }
            logger.info("Trovate {} prenotazioni", listReservations.size());
            return listReservationsDTO;
        } catch (Exception e) {
            logger.error("Errore durante il recupero delle prenotazioni", e);
            return null;
        }
    }

    @Override
    public boolean updateReservation(long id, ReservationDTO reservationDTO) {
        try {
            reservationRepository.save(fromDTOToReservation(reservationDTO, reservationRepository.findById(id).orElse(null)));
            logger.info("Prenotazione con ID {} aggiornata con successo", id);
            return true;
        } catch (Exception e) {
            logger.error("Errore durante l'aggiornamento della prenotazione con ID {}", id, e);
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

        List<RestaurantTable> eligibleTables = elegibleTables(reservationDTO);

        RestaurantTable freeTable = freeTable(eligibleTables, reservation.getReservationDate(),
                reservation.getReservationStartTime(), reservation.getReservationEndTime());

        reservation.setRestaurantTable(freeTable);
        reservation.setUser(userRepository.findById(reservationDTO.getUserId()).orElse(null));
        return reservation;
    }

    private List<RestaurantTable> elegibleTables(ReservationDTO reservationDTO) {
        return tableRepository.findAll().stream()
                .filter(table -> table.getSeats() == reservationDTO.getNumberOfGuests()
                        && table.getTableType().equals(reservationDTO.getTableType()))
                .collect(Collectors.toList());
    }

    private RestaurantTable freeTable(List<RestaurantTable> eligibleTables, LocalDate reservationDate,
                                      LocalTime reservationStartTime, LocalTime reservationEndTime) {
        try {
            List<Reservation> overlappingReservations = reservationRepository.findAll().stream()
                    .filter(reservation ->
                            reservation.getReservationDate().isEqual(reservationDate) &&
                                    (
                                            (reservationStartTime.isBefore(reservation.getReservationEndTime()) && reservation.getReservationStartTime().isBefore(reservationEndTime)) &&
                                                    (reservationEndTime.isAfter(reservation.getReservationStartTime()) && reservation.getReservationEndTime().isAfter(reservationStartTime))
                                    )
                    )
                    .collect(Collectors.toList());

            List<RestaurantTable> reservedTables = overlappingReservations.stream()
                    .map(Reservation::getRestaurantTable)
                    .collect(Collectors.toList());

            List<RestaurantTable> availableTables = eligibleTables.stream()
                    .filter(table -> !reservedTables.contains(table))
                    .collect(Collectors.toList());

            if (!availableTables.isEmpty()) {
                logger.info("Trovato tavolo disponibile: {}", availableTables.get(0).getId());
                return availableTables.get(0);
            } else {
                logger.warn("Nessun tavolo disponibile per la prenotazione");
                return null;
            }
        } catch (Exception e) {
            logger.error("Errore durante la ricerca di un tavolo libero", e);
            return null;
        }
    }
}