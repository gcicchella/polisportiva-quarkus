package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.ReservationRating;
import org.example.Service.ReservationRatingService;

import java.util.List;

@Path("/api/reservations-rating")
public class ReservationRatingController {

    @Inject
    ReservationRatingService reservationRatingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try{
            List<ReservationRating> reservationRatings = reservationRatingService.findAll();
            if(reservationRatings.size() != 0){
                return Response.ok(reservationRatings).build();
            }
            return Response.serverError().entity("Recensioni sulle prenotazioni non trovate").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }
}
