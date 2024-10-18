package it.its.formazione.springboot.esercizio2.filippo_aprile.exception;

public class InvalidBookingDatesException extends RuntimeException {
    public InvalidBookingDatesException(String message) {
        super(message);
    }
}