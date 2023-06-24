package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Repository.ReservationRepository;

@Singleton
public class ReservationServiceImplementation implements ReservationService {

    @Inject
    private ReservationRepository reservationRepository;
}
