package it.its.formazione.springboot.esercizio2.filippo_aprile.service;

import it.its.formazione.springboot.esercizio2.filippo_aprile.model.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> getAllBookings();

    BookingDTO getBookingById(Integer id);

    BookingDTO createBooking(BookingDTO bookingDTO);

    BookingDTO updateBooking(Integer id, BookingDTO bookingDTO);

    void deleteBooking(Integer id);
}
