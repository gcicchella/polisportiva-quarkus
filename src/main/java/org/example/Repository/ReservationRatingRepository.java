package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.ReservationRating;

@ApplicationScoped
public class ReservationRatingRepository implements PanacheRepositoryBase<ReservationRating, Long> {


}

