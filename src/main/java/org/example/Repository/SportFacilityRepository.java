package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.Model.SportFacility;

import java.util.List;

@ApplicationScoped
public class SportFacilityRepository implements PanacheRepositoryBase<SportFacility, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SportFacility> getSportsFacilityByUserId(Long id_user) {
        return entityManager.createQuery("SELECT sf FROM sports_facility sf WHERE sf.user.id = :id_user", SportFacility.class)
                .setParameter("id_user", id_user)
                .getResultList();
    }
}

