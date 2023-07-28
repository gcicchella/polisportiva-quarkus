package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.SportField;

@ApplicationScoped
public class SportFieldRepository implements PanacheRepositoryBase<SportField, Long> {
}

