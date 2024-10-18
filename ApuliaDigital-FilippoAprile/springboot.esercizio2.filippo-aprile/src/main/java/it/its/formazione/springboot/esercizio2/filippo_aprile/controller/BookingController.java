package it.its.formazione.springboot.esercizio2.filippo_aprile.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.springboot.esercizio2.filippo_aprile.api.BookingsApi;
import it.its.formazione.springboot.esercizio2.filippo_aprile.model.BookingDTO;
import it.its.formazione.springboot.esercizio2.filippo_aprile.service.BookingService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController implements BookingsApi {

    @Autowired
    private BookingService bookingService;

    Logger log = LoggerFactory.getLogger(BookingController.class);


    public ResponseEntity<BookingDTO> createBooking(
            @Parameter(name = "BookingDTO", description = "", required = true) @Valid @RequestBody BookingDTO bookingDTO
    ) {
        log.info("Ingresso nel metodo createBooking");
        BookingDTO createdBooking = bookingService.createBooking(bookingDTO);
        log.info("Uscita dal metodo createBooking con risultato: {}", createdBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    public ResponseEntity<Void> deleteBooking(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo deleteBooking per l'id: {}", id);
        bookingService.deleteBooking(id);
        log.info("Uscita dal metodo deleteBooking");
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<BookingDTO>> getAllBookings(

    ) {
        log.info("Ingresso nel metodo getAllBookings");
        List<BookingDTO> bookings = bookingService.getAllBookings();
        log.info("Uscita dal metodo getAllBookings con {} prenotazioni", bookings.size());
        return ResponseEntity.ok(bookings);
    }

    public ResponseEntity<BookingDTO> getBookingById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    ) {
        log.info("Ingresso nel metodo getBookingById per l'id: {}", id);
        BookingDTO booking = bookingService.getBookingById(id);
        log.info("Uscita dal metodo getBookingById con risultato: {}", booking);
        return ResponseEntity.ok(booking);
    }

    public ResponseEntity<BookingDTO> updateBooking(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "BookingDTO", description = "", required = true) @Valid @RequestBody BookingDTO bookingDTO
    ) {
        log.info("Ingresso nel metodo updateBooking per l'id: {}", id);
        BookingDTO updatedBooking = bookingService.updateBooking(id, bookingDTO);
        log.info("Uscita dal metodo updateBooking con risultato: {}", updatedBooking);
        return ResponseEntity.ok(updatedBooking);
    }
}
