package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.SportsField;

@ApplicationScoped
public class SportsFieldRepository implements PanacheRepositoryBase<SportsField, Long> {
}

