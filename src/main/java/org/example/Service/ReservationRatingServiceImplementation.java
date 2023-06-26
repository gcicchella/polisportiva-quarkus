package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Response;
import org.example.Model.ReservationRating;
import org.example.Repository.ReservationRatingRepository;

import java.util.List;

@Singleton
public class ReservationRatingServiceImplementation implements ReservationRatingService {

    @Inject
    private ReservationRatingRepository reservationRatingRepository;

    @Override
    public Response findAll() {
        try{
            List<ReservationRating> reservationRatings = reservationRatingRepository.listAll();
            return Response.ok(reservationRatings).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }
}