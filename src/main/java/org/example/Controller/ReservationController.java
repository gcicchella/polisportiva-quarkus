package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Model.Reservation;
import org.example.Service.ReservationService;

@Path("/api/reservations")
public class ReservationController {

    @Inject
    ReservationService reservationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return reservationService.findAll();
    }

    @POST
    public Response createReservation(ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO);
    }

    @DELETE
    @Path("/{id_reservation}")
    public Response deleteReservation(@PathParam("id_reservation") Long id_reservation) {
        return reservationService.deleteReservation(id_reservation);
    }
}
