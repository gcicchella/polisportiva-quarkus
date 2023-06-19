package org.example.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.Model.Address;

@ApplicationScoped
public class AddressRepository implements PanacheRepositoryBase<Address, String> {
}