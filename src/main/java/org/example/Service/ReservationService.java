package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Altro.Enumeration.ReservationStatus;
public interface ReservationService {
    Response findAll();

    Response createReservation(ReservationDTO reservationDTO);

    Response deleteReservation(Long id_reservation);

    Response changeStatus(Long id_reservation, ReservationStatus reservationStatus);
}
