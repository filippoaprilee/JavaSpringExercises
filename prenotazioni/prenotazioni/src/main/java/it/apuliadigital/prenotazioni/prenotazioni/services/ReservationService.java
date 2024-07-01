package it.apuliadigital.prenotazioni.prenotazioni.services;

import java.util.List;

import it.apuliadigital.prenotazioni.prenotazioni.entities.Reservation;
import it.apuliadigital.prenotazioni.prenotazioni.entitiesDTO.ReservationDTO;

public interface ReservationService {
    public boolean addReservation(ReservationDTO reservationDTO);
    public boolean removeReservation(long id);
    public ReservationDTO getReservation(long id);
    public List<ReservationDTO> getReservations();
    public boolean updateReservation(long id, ReservationDTO reservationDTO);    
    public ReservationDTO fromReservationToDTO(Reservation reservation, ReservationDTO reservationDTO);
    public Reservation fromDTOToReservation(ReservationDTO reservationDTO, Reservation reservation);
}
