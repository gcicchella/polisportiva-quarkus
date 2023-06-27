package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.ReservationRating;

import java.util.List;

public interface ReservationRatingService {

    List<ReservationRating> findAll();
}
