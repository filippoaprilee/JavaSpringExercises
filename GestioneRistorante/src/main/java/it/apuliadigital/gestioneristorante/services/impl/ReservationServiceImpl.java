package it.apuliadigital.gestioneristorante.services.impl;

import it.apuliadigital.gestioneristorante.entities.Reservation;
import it.apuliadigital.gestioneristorante.entities.DiningTable;
import it.apuliadigital.gestioneristorante.entities.User;
import it.apuliadigital.gestioneristorante.entitiesdto.ReservationDTO;
import it.apuliadigital.gestioneristorante.repositories.ReservationRepository;
import it.apuliadigital.gestioneristorante.repositories.DiningTableRepository;
import it.apuliadigital.gestioneristorante.repositories.UserRepository;
import it.apuliadigital.gestioneristorante.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiningTableRepository tableRepository;

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) {
        try {
            Reservation reservation = fromDTOToReservation(reservationDTO);
            reservationRepository.save(reservation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getReservations(List<ReservationDTO> reservationDTOList) {
        try {
            List<Reservation> reservations = reservationRepository.findAll();
            for (Reservation reservation : reservations) {
                reservationDTOList.add(fromReservationToDTO(reservation));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean getReservationById(Long id, ReservationDTO reservationDTO) {
        if (reservationRepository.existsById(id)) {
            try {
                Reservation reservation = reservationRepository.findById(id).get();
                ReservationDTO dto = fromReservationToDTO(reservation);
                reservationDTO.setUserId(dto.getUserId());
                reservationDTO.setTableId(dto.getTableId());
                reservationDTO.setReservationDate(dto.getReservationDate());
                reservationDTO.setStartTime(dto.getStartTime());
                reservationDTO.setEndTime(dto.getEndTime());
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean updateReservation(Long id, ReservationDTO reservationDTO) {
        if (reservationRepository.existsById(id)) {
            try {
                Reservation foundReservation = reservationRepository.findById(id).get();
                foundReservation = fromDTOToReservation(reservationDTO);
                reservationRepository.save(foundReservation);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            try {
                reservationRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private ReservationDTO fromReservationToDTO(Reservation reservation) {
        if (reservation == null || reservation.getUser() == null || reservation.getTable() == null) {
            return null;
        }
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setUserId(reservation.getUser().getId());
        reservationDTO.setTableId(reservation.getTable().getId());
        reservationDTO.setNumberOfGuests(reservation.getTable().getSeats());
        reservationDTO.setReservationDate(reservation.getDate());
        reservationDTO.setStartTime(reservation.getStartTime());
        reservationDTO.setEndTime(reservation.getEndTime());
        return reservationDTO;
    }

    private Reservation fromDTOToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        Optional<User> optUser = userRepository.findById(reservationDTO.getUserId());
        if (optUser.isPresent()) {
            reservation.setUser(optUser.get());
        }
        else {
            return null;
        }
        Optional<DiningTable> optTable = tableRepository.findById(reservationDTO.getTableId());
        if (optTable.isPresent()) {
            reservation.setTable(optTable.get());
        }
        else {
            return null;
        }
        reservation.setDate(reservationDTO.getReservationDate());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        return reservation;
    }
}
