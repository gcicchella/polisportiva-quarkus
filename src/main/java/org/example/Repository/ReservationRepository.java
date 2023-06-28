package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.Altro.Enumeration.ReservationStatus;
import org.example.Model.Reservation;
import org.example.Model.SportFacility;
import org.glassfish.jaxb.core.v2.TODO;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

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

    public List<Reservation> getReservationByFacilityId(Long id_sports_facility, Date startDate, Date endDate) {
        ZonedDateTime startDateZoned = startDate.toInstant().atZone(ZoneId.systemDefault());
        ZonedDateTime endDateZoned = endDate.toInstant().atZone(ZoneId.systemDefault());

        return entityManager.createQuery("SELECT r FROM reservation r JOIN sports_field sf ON r.sportField.id = sf.id " +
                        "WHERE (sf.sportFacility.id = :id_sports_facility)" +
                        " AND (r.startDateTime >= :startDateZoned AND r.endDateTime <= :endDateZoned) ", Reservation.class)
                .setParameter("id_sports_facility", id_sports_facility)
                .setParameter("startDateZoned", startDateZoned)
                .setParameter("endDateZoned", endDateZoned)
                .getResultList();
    }
}