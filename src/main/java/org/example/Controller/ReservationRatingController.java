package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Service.ReservationRatingService;

@Path("/api/reservations-rating")
public class ReservationRatingController {

    @Inject
    ReservationRatingService reservationRatingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return reservationRatingService.findAll();
    }
}
