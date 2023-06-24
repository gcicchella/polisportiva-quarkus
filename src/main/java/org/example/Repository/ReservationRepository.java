package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.Reservation;

@ApplicationScoped
public class ReservationRepository implements PanacheRepositoryBase<Reservation, Long> {
}