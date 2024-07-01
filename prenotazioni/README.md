import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    // ... altri metodi del servizio

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

    // Aggiungi anche logging per il metodo freeTable
    public RestaurantTable freeTable(List<RestaurantTable> eligibleTables, LocalDate reservationDate,
            LocalTime reservationStartTime, LocalTime reservationEndTime) {
        try {
            // Tuo codice attuale per il metodo freeTable

            logger.info("Eligible tables: {}", eligibleTables.size());
            eligibleTables.forEach(table -> logger.info("Eligible table: {}", table.getId()));

            if (!availableTables.isEmpty()) {
                return availableTables.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Errore durante la ricerca di un tavolo libero", e);
            return null;
        }
    }
}