package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;
import org.example.Model.ReservationRating;
import org.example.Model.SportField;
import org.example.Model.User;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();

    Reservation createReservation(User user, SportField sportField, ReservationDTO reservationDTO);

    boolean deleteReservation(Long id_reservation);

    Reservation getReservationById(Long id_reservation);

    List<Reservation> getReservationByFacilityId(Long id_sports_facility, Date starDate, Date endDate);

    Reservation changeStatus(Long id_reservation, ReservationStatus reservationStatus);

    ReservationRating createReservationRating(Reservation reservation, ReservationRating reservationRating);
}
