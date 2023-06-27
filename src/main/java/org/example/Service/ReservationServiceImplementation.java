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
import java.util.List;

@Singleton
public class ReservationServiceImplementation implements ReservationService {

    @Inject
    private ReservationRepository reservationRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private SportFieldRepository sportFieldRepository;

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

//    @Transactional
//    @Override
//    public Response createReservation(ReservationDTO reservationDTO) {
//        try{
//            User user = userRepository.findById(reservationDTO.getOwnerId());
//            if(user == null){
//                return Response.serverError().entity("Utente non trovato").build();
//            }
//            SportField sportField = sportFieldRepository.findById(reservationDTO.getSportsFieldId());
//            if(sportField == null){
//                return Response.serverError().entity("Campo non trovato").build();
//            }
//            Reservation reservation = new Reservation();
//            reservation.setStartDateTime(reservationDTO.getStartDate());
//            reservation.setEndDateTime(reservationDTO.getEndDate());
//            reservation.setCreatedAt(ZonedDateTime.now());
//            reservation.setState(ReservationStatus.PENDING);
//            reservation.setPrice((double) 0);
//            reservation.setUser(user);
//            reservation.setSportsField(sportField);
//            reservationRepository.persist(reservation);
//            return Response.ok("Prenotazione creata").build();
//        } catch (Exception e) {
//            return Response.serverError().entity("Prenotazione non creata").build();
//        }
//    }

    @Transactional
    @Override
    public boolean deleteReservation(Long id_reservation) {
       return reservationRepository.deleteById(id_reservation);
    }

    @Override
    public Reservation getReservationById(Long id_reservation) {
        return reservationRepository.findById(id_reservation);
    }

    @Transactional
    @Override
    public Reservation changeStatus(Long id_reservation, ReservationStatus reservationStatus) {
        return reservationRepository.updateStatus(id_reservation, reservationStatus);
    }

    @Transactional
    @Override
    public ReservationRating createReservationRating(Long id_reservation, ReservationRating reservationRating) {
        reservationRating.setRating(reservationRating.getRating());
        reservationRating.setDescription(reservationRating.getDescription());
        reservationRatingRepository.persist(reservationRating);
        ReservationRating reservationRating1 = reservationRatingRepository.findById(reservationRating.getId());
        if(reservationRating1 != null){
            return reservationRating1;
        }
        else return null;
    }

//    @Transactional
//    @Override
//    public Response createReservationRating(Long id_reservation, ReservationRating reservationRating) {
//        try{
//            Reservation reservation =  reservationRepository.findById(id_reservation);
//            if(reservation == null){
//                return Response.serverError().entity("Prenotazione non trovata").build();
//            }
//            reservationRating.setRating(reservationRating.getRating());
//            reservationRating.setDescription(reservationRating.getDescription());
//            reservationRatingRepository.persist(reservationRating);
//            return Response.ok("Valutazione assegnata").build();
//        } catch (Exception e) {
//            return Response.serverError().entity("Valutazione non assegnata").build();
//        }
//    }

}
