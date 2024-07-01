package it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationDTO {

    private long userId;
    private int numberOfGuests;
    private String tableType;
    private LocalDate reservationDate;
    private LocalTime reservationStartTime;

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getNumberOfGuests() {
        return this.numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getTableType() {
        return this.tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationStartTime() {
        return this.reservationStartTime;
    }

    public void setReservationStartTime(LocalTime reservationStartTime) {
        this.reservationStartTime = reservationStartTime;
    }
    
}
