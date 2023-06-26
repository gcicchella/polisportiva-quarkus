package org.example.Controller;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.ReservationRating;
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id_reservation}/status")
    public Response changeStatus(@PathParam("id_reservation") Long id_reservation, JsonObject json){
        ReservationStatus reservationStatus = ReservationStatus.valueOf(json.getString("state"));
        System.out.println(reservationStatus);
        return reservationService.changeStatus(id_reservation, reservationStatus);
    }

    @POST
    @Path("/{id_reservation}/rating")
    public Response createReservationRating(@PathParam("id_reservation") Long id_reservation, ReservationRating reservationRating) {
        return reservationService.createReservationRating(id_reservation, reservationRating);
    }

}
