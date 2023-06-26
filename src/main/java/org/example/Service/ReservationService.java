package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Model.Reservation;

public interface ReservationService {
    Response findAll();

    Response createReservation(ReservationDTO reservationDTO);

    Response deleteReservation(Long id_reservation);
}
