package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.SportsFacility;

@ApplicationScoped
public class SportsFacilityRepository implements PanacheRepositoryBase<SportsFacility, Long> {
}

