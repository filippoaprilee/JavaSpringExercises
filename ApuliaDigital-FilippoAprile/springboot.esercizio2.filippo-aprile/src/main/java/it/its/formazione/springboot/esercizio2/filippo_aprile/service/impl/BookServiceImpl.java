package it.its.formazione.springboot.esercizio2.filippo_aprile.service.impl;

import it.its.formazione.springboot.esercizio2.filippo_aprile.controller.BookingController;
import it.its.formazione.springboot.esercizio2.filippo_aprile.entity.BookingEntity;
import it.its.formazione.springboot.esercizio2.filippo_aprile.exception.BookingAlreadyExistsException;
import it.its.formazione.springboot.esercizio2.filippo_aprile.exception.BookingNotFoundException;
import it.its.formazione.springboot.esercizio2.filippo_aprile.exception.InvalidBookingDatesException;
import it.its.formazione.springboot.esercizio2.filippo_aprile.mapper.BookingMapper;
import it.its.formazione.springboot.esercizio2.filippo_aprile.model.BookingDTO;
import it.its.formazione.springboot.esercizio2.filippo_aprile.repository.BookingRepository;
import it.its.formazione.springboot.esercizio2.filippo_aprile.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Override
    public List<BookingDTO> getAllBookings() {
        List<BookingEntity> entities = (List<BookingEntity>) bookingRepository.findAll();

        if (entities.isEmpty()) {
            logger.warn("Nessuna prenotazione trovata.");
            throw new BookingNotFoundException("Nessuna prenotazione trovata.");
        }

        logger.info("Trovate {} prenotazioni.", entities.size());
        return entities.stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public BookingDTO getBookingById(Integer id) {
        BookingEntity entity = bookingRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Prenotazione non trovata per id: {}", id);
                    return new BookingNotFoundException("Prenotazione non trovata per id: " + id);
                });
        return bookingMapper.toDTO(entity);
    }

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        validateBookingDates(bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate());

        // Controlla le prenotazioni esistenti per la camera
        checkOverlappingBookings(bookingDTO.getRoomNumber(), bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate());

        BookingEntity entity = bookingMapper.toEntity(bookingDTO);
        bookingRepository.save(entity);
        bookingDTO.setId(entity.getId());
        logger.info("Prenotazione creata con id: {}", entity.getId());
        return bookingDTO;
    }

    @Override
    public BookingDTO updateBooking(Integer id, BookingDTO bookingDTO) {
        if (!bookingRepository.existsById(id)) {
            logger.error("Prenotazione non trovata per id: {}", id);
            throw new BookingNotFoundException("Prenotazione non trovata per id: " + id);
        }

        validateBookingDates(bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate());

        // Controllo sovrapposizione prenotazioni
        checkOverlappingBookings(bookingDTO.getRoomNumber(), bookingDTO.getCheckInDate(), bookingDTO.getCheckOutDate());

        BookingEntity entity = bookingMapper.toEntity(bookingDTO);
        entity.setId(id);
        bookingRepository.save(entity);
        logger.info("Prenotazione aggiornata con id: {}", id);
        return bookingDTO;
    }

    @Override
    public void deleteBooking(Integer id) {
        if (!bookingRepository.existsById(id)) {
            logger.error("Prenotazione non trovata per id: {}", id);
            throw new BookingNotFoundException("Prenotazione non trovata per id: " + id);
        }
        bookingRepository.deleteById(id);
        logger.info("Prenotazione eliminata con id: {}", id);
    }

    private void validateBookingDates(String checkInDate, String checkOutDate) {
        if (checkInDate.compareTo(checkOutDate) >= 0) {
            throw new InvalidBookingDatesException("La data di check-out deve essere successiva alla data di check-in.");
        }
    }

    private void checkOverlappingBookings(Integer roomNumber, String checkInDate, String checkOutDate) {
        List<BookingEntity> existingBookings = bookingRepository.findByRoomNumber(roomNumber);

        for (BookingEntity booking : existingBookings) {
            String existingCheckIn = booking.getCheckInDate();
            String existingCheckOut = booking.getCheckOutDate();

            // Controllo per sovrapposizioni
            if ((checkInDate.compareTo(existingCheckOut) < 0) && (checkOutDate.compareTo(existingCheckIn) > 0)) {
                logger.error("Sovrapposizione di prenotazione per la camera {}: già prenotata da {} a {}",
                        roomNumber, existingCheckIn, existingCheckOut);
                throw new BookingAlreadyExistsException("La camera " + roomNumber + " è già prenotata nel periodo selezionato.");
            }
        }
    }
}
