package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;

@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<Reservation, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public Reservation updateStatus(Long id_reservation, ReservationStatus reservationStatus) {
        Query query = entityManager.createQuery("UPDATE reservation r " +
                        "SET r.state = :reservationStatus WHERE r.id = :id_reservation")
                .setParameter("reservationStatus", reservationStatus)
                .setParameter("id_reservation", id_reservation);
        query.executeUpdate();
        return entityManager.find(Reservation.class, id_reservation);
    }



}