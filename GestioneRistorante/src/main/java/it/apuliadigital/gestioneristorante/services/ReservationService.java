package it.apuliadigital.gestioneristorante.services;

import it.apuliadigital.gestioneristorante.entitiesdto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    boolean addReservation(ReservationDTO reservationDTO);
    boolean getReservations(List<ReservationDTO> reservationDTOList);
    boolean getReservationById(Long id, ReservationDTO reservationDTO);
    boolean updateReservation(Long id, ReservationDTO reservationDTO);
    boolean deleteReservation(Long id);
}
