package it.its.formazione.springboot.esercizio2.filippo_aprile.exception;

public class BookingAlreadyExistsException extends RuntimeException {
    public BookingAlreadyExistsException(String message) {
        super(message);
    }
}
