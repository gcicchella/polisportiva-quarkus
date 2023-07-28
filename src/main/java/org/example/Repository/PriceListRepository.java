package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.PriceList;

@ApplicationScoped
public class PriceListRepository implements PanacheRepositoryBase<PriceList, Long> {
}
