package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.User;
import org.example.Service.UserService;

import java.util.List;

@Path("/api/users")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try{
            List<User> userList = userService.findAll();
            if(userList.size() != 0){
                return Response.ok(userList).build();
            }
            return Response.serverError().entity("Utenti non trovati").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @POST
    public Response createUser(User user) {
        try {
            User user1 = userService.createUser(user);
            if(user1 != null){
                return Response.ok(user1).build();
            }
            return Response.serverError().entity("Utente non creato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Utente non creato").build();
        }
    }

    @DELETE
    @Path("/{id_user}")
    public Response deleteUser(@PathParam("id_user") Long id_user) {
        try {
            if(userService.deleteUser(id_user)){
                return Response.ok("Utente eliminato").build();
            }
            return Response.serverError().entity("Utente non eliminato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Utente non eliminato").build();
        }
    }

    @GET
    @Path("/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id_user") Long id_user) {
        try{
            User user = userService.getUserById(id_user);
            if(user != null){
                return Response.ok(user).build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }
}
