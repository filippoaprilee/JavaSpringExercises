package it.its.formazione.springboot.esercizio2.filippo_aprile.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
