package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Model.ReservationRating;
import org.example.Repository.ReservationRatingRepository;

import java.util.List;

@Singleton
public class ReservationRatingServiceImplementation implements ReservationRatingService {

    @Inject
    private ReservationRatingRepository reservationRatingRepository;

    @Override
    public List<ReservationRating> findAll() {
        return reservationRatingRepository.listAll();
    }
}