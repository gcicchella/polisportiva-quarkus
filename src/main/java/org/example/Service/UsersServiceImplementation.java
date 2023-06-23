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

@Singleton
public class UsersServiceImplementation implements UsersService {
    @Inject
    private UsersRepository usersRepository;

    @Inject
    private AddressRepository addressRepository;

    @Override
    public Response findAll() {
        try{
            List<User> userList = usersRepository.listAll();
            return Response.ok(userList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    public Response createUser(User user) {
        try {
            //Address address = user.getAddress();
            //addressRepository.persist(address);
            //user.setAddress(address);
            usersRepository.persist(user);
            return Response.ok("Utente creato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Utente non creato").build();
        }
    }

    @Transactional
    @Override
    public Response deleteUser(String id_user) {
        try {
            Boolean response = usersRepository.deleteById(id_user);
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
    public Response getUserById(String id_user) {
        try{
            User user = usersRepository.findById(id_user);
            if(user == null) return Response.status(404).entity("Utente non trovato").build();
            return Response.ok(user).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

}



