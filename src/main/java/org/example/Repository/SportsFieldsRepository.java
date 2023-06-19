package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.SportsFields;

@ApplicationScoped
public class SportsFieldsRepository implements PanacheRepositoryBase<SportsFields, String> {
}

