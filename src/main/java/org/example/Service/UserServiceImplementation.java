package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.example.Model.User;
import org.example.Repository.UserRepository;

import java.util.List;

@Singleton
public class UserServiceImplementation implements UserService {
    @Inject
    private UserRepository userRepository;

//    @Override
//    public Response findAll() {
//        try{
//            List<User> userList = usersRepository.listAll();
//            return Response.ok(userList).build();
//        }
//        catch (Exception e){
//            return Response.serverError().entity("Errore durante la ricerca").build();
//        }
//    }

    @Override
    public List<User> findAll() {
       return userRepository.listAll();
    }

//    @Transactional
//    public Response createUser(User user) {
//        try {
//            usersRepository.persist(user);
//            return Response.ok("Utente creato").build();
//        } catch (Exception e) {
//            return Response.serverError().entity("Utente non creato").build();
//        }
//    }

    @Transactional
    public User createUser(User user) {
        userRepository.persist(user);
        User user1 = userRepository.findById(user.getId());
        if(user1 != null){
            return user1;
        }
        else return null;
    }


//    @Transactional
//    @Override
//    public Response deleteUser(Long id_user) {
//        try {
//            Boolean response = usersRepository.deleteById(id_user);
//            String msg = "Utente non eliminato";
//            if(response){
//                msg = "Utente eliminato";
//            }
//            return Response.ok(msg).build();
//
//        } catch (Exception e) {
//            return Response.serverError().entity("Utente non eliminato").build();
//        }
//    }

    @Transactional
    @Override
    public boolean deleteUser(Long id_user) {
        return userRepository.deleteById(id_user);
    }

//    @Override
//    public Response getUserById(Long id_user) {
//        try{
//            User user = usersRepository.findById(id_user);
//            if(user == null) return Response.status(404).entity("Utente non trovato").build();
//            return Response.ok(user).build();
//        }
//        catch (Exception e){
//            return Response.serverError().entity("Errore nella ricerca").build();
//        }
//    }

    @Override
    public User getUserById(Long id_user) {
        return userRepository.findById(id_user);
    }

}



