package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.User;

@ApplicationScoped
public class UserRepository implements PanacheRepositoryBase<User, Long> {
}
