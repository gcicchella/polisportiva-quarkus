package org.example.Controller;

import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;
import org.example.Model.ReservationRating;
import org.example.Model.SportField;
import org.example.Model.User;
import org.example.Service.ReservationService;
import org.example.Service.SportFieldService;
import org.example.Service.UserService;

import java.util.List;

@Path("/api/reservations")
public class ReservationController {

    @Inject
    ReservationService reservationService;

    @Inject
    UserService userService;

    @Inject
    SportFieldService sportFieldService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try{
            List<Reservation> reservations = reservationService.findAll();
            if(reservations.size() != 0){
                return Response.ok(reservations).build();
            }
            return Response.serverError().entity("Prenotazioni non trovate").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @POST
    public Response createReservation(ReservationDTO reservationDTO) {
        try {
            User user = userService.getUserById(reservationDTO.getOwnerId());
            if(user == null){
                return Response.serverError().entity("Utente non trovato").build();
            }
            SportField sportField =  sportFieldService.getSportsFieldsById(reservationDTO.getSportsFieldId());
            if(sportField == null){
                return Response.serverError().entity("Campo sportivo non trovato").build();
            }
            Reservation reservation = reservationService.createReservation(user, sportField, reservationDTO);
            if(reservation != null){
                return Response.ok(reservation).build();
            }
            return Response.serverError().entity("Prenotazione non creata").build();
        } catch (Exception e) {
            return Response.serverError().entity("Prenotazione non creata").build();
        }
    }

    @DELETE
    @Path("/{id_reservation}")
    public Response deleteReservation(@PathParam("id_reservation") Long id_reservation) {
        try {
            if(reservationService.deleteReservation(id_reservation)){
                return Response.ok("Prenotazione eliminata").build();
            }
            return Response.serverError().entity("Prenotazione non eliminata").build();
        } catch (Exception e) {
            return Response.serverError().entity("Prenotazione non eliminata").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id_reservation}/status")
    public Response changeStatus(@PathParam("id_reservation") Long id_reservation, JsonObject json){
        try {
            if(reservationService.getReservationById(id_reservation) == null){
                return Response.serverError().entity("Prenotazione non trovata").build();
            }
            ReservationStatus reservationStatus = ReservationStatus.valueOf(json.getString("state").toUpperCase());
            Reservation reservation = reservationService.changeStatus(id_reservation, reservationStatus);
            if(reservation != null){
                return Response.ok(reservation).build();
            }
            return Response.serverError().entity("Prenotazione non creata").build();
        } catch (Exception e) {
            return Response.serverError().entity("Prenotazione non modificata").build();
        }
    }

    @POST
    @Path("/{id_reservation}/rating")
    public Response createReservationRating(@PathParam("id_reservation") Long id_reservation, ReservationRating reservationRating) {
        try {
            Reservation reservation = reservationService.getReservationById(id_reservation);
            if (reservation != null) {
               ReservationRating reservationRating1 = reservationService.createReservationRating(reservation, reservationRating);
                if(reservationRating1 != null){
                    return Response.ok(reservationRating1).build();
                }
                return Response.serverError().entity("Recensione sulla prenotazione non creata").build();
            }
            return Response.serverError().entity("Prenotazione non trovata").build();
        }
        catch (Exception e) {
            return Response.serverError().entity("Recensione sulla prenotazione non creata").build();
        }
    }
}
