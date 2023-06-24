package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.example.Service.ReservationService;

@Path("/api/reservation")
public class ReservationController {

    @Inject
    ReservationService reservationService;
}
