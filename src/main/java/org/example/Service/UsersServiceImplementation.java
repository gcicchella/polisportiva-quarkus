package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.example.Model.Address;
import org.example.Model.User;
import org.example.Repository.AddressRepository;
import org.example.Repository.UsersRepository;

import java.util.List;
import java.util.UUID;

@Singleton
public class UsersServiceImplementation implements UsersService{
    @Inject
    private UsersRepository usersRepository;

    @Inject
    private AddressRepository addressRepository;

    @Override
    public List<User> findAll() {
        return usersRepository.listAll();
    }

    @Transactional
    public Response createUser(User user) {
        try {
            Address address = user.getAddress();
            address.setId(UUID.randomUUID().toString());
            addressRepository.persist(address);

            user.setAddress(address);
            user.setId(UUID.randomUUID().toString());
            usersRepository.persist(user);

            return Response.ok("Utente creato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Utente non creato").build();
        }
    }

    @Transactional
    @Override
    public Response deleteUser(String userId) {
        try {
            Boolean response = usersRepository.deleteById(userId);
            String msg = "Utente non eliminato";
            if(response){
                msg = "Utente eliminato";
            }
            return Response.ok(msg).build();

        } catch (Exception e) {
            return Response.serverError().entity("Utente non eliminato").build();
        }
    }

    @Override
    public Response getUserById(String userId) {
        try{
            User user = usersRepository.findById(userId);
            return Response.ok(user).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Utente non trovato").build();
        }
    }

}



