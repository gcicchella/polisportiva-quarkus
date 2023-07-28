package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.example.Altro.DTO.ReservationDTO;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;
import org.example.Model.ReservationRating;
import org.example.Model.SportField;
import org.example.Model.User;
import org.example.Repository.ReservationRatingRepository;
import org.example.Repository.ReservationRepository;
import org.example.Repository.SportFieldRepository;
import org.example.Repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Singleton
public class ReservationServiceImplementation implements ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    @Inject
    private ReservationRatingRepository reservationRatingRepository;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.listAll();
    }

    @Transactional
    @Override
    public Reservation createReservation(User user, SportField sportField, ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setStartDateTime(reservationDTO.getStartDate());
        reservation.setEndDateTime(reservationDTO.getEndDate());
        reservation.setCreatedAt(ZonedDateTime.now());
        reservation.setState(ReservationStatus.PENDING);
        reservation.setPrice((double) 0);
        reservation.setUser(user);
        reservation.setSportsField(sportField);
        reservationRepository.persist(reservation);
        Reservation reservation1 = reservationRepository.findById(reservation.getId());
        if(reservation1 != null){
            return reservation1;
        }
        else return null;
    }

    @Transactional
    @Override
    public boolean deleteReservation(Long id_reservation) {
       return reservationRepository.deleteById(id_reservation);
    }

    @Override
    public Reservation getReservationById(Long id_reservation) {
        return reservationRepository.findById(id_reservation);
    }

    @Override
    public List<Reservation> getReservationByFacilityId(Long id_sports_facility, Date starDate, Date endDate) {
        return reservationRepository.getReservationByFacilityId(id_sports_facility, starDate, endDate);
    }

    @Transactional
    @Override
    public Reservation changeStatus(Long id_reservation, ReservationStatus reservationStatus) {
        return reservationRepository.updateStatus(id_reservation, reservationStatus);
    }

    @Transactional
    @Override
    public ReservationRating createReservationRating(Reservation reservation, ReservationRating reservationRating) {
        reservationRating.setRating(reservationRating.getRating());
        reservationRating.setDescription(reservationRating.getDescription());
        reservationRating.setReservation(reservation);
        reservationRatingRepository.persist(reservationRating);
        ReservationRating reservationRating1 = reservationRatingRepository.findById(reservationRating.getId());
        if(reservationRating1 != null){
            return reservationRating1;
        }
        else return null;
    }
}
