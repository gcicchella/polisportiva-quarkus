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
    public Response findAll() {
        try{
            List<Reservation> reservationsList = reservationRepository.listAll();
            return Response.ok(reservationsList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    @Override
    public Response createReservation(ReservationDTO reservationDTO) {
        try{
            User user = userRepository.findById(reservationDTO.getOwnerId());
            if(user == null){
                return Response.serverError().entity("Utente non trovato").build();
            }
            SportField sportField = sportFieldRepository.findById(reservationDTO.getSportsFieldId());
            if(sportField == null){
                return Response.serverError().entity("Campo non trovato").build();
            }
            Reservation reservation = new Reservation();
            reservation.setStartDateTime(reservationDTO.getStartDate());
            reservation.setEndDateTime(reservationDTO.getEndDate());
            reservation.setCreatedAt(ZonedDateTime.now());
            reservation.setState(ReservationStatus.PENDING);
            reservation.setPrice((double) 0);
            reservation.setUser(user);
            reservation.setSportsField(sportField);
            reservationRepository.persist(reservation);
            return Response.ok("Prenotazione creata").build();
        } catch (Exception e) {
            return Response.serverError().entity("Prenotazione non creata").build();
        }
    }

    @Transactional
    @Override
    public Response deleteReservation(Long id_reservation) {
        try {
            Boolean response = reservationRepository.deleteById(id_reservation);
            String msg = "Prenotazione non eliminata";
            if(response){
                msg = "Prenotazione eliminata";
            }
            return Response.ok(msg).build();
        } catch (Exception e) {
            return Response.serverError().entity("Prenotazione non eliminata").build();
        }
    }

    @Transactional
    @Override
    public Response changeStatus(Long id_reservation, ReservationStatus reservationStatus) {
        try {
            Reservation reservation = reservationRepository.updateStatus(id_reservation, reservationStatus);
            if (reservation == null) {
                return Response.serverError().entity("Prenotazione non trovata").build();
            }
            return Response.ok("Stato modificato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Stato non modificato").build();
        }
    }

    @Transactional
    @Override
    public Response createReservationRating(Long id_reservation, ReservationRating reservationRating) {
        try{
            Reservation reservation =  reservationRepository.findById(id_reservation);
            if(reservation == null){
                return Response.serverError().entity("Prenotazione non trovata").build();
            }
            reservationRating.setRating(reservationRating.getRating());
            reservationRating.setDescription(reservationRating.getDescription());
            reservationRatingRepository.persist(reservationRating);
            return Response.ok("Valutazione assegnata").build();
        } catch (Exception e) {
            return Response.serverError().entity("Valutazione non assegnata").build();
        }
    }

}
