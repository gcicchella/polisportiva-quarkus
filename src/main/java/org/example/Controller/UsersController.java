package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.User;
import org.example.Service.UsersService;

@Path("/api/users")
public class UsersController {

    @Inject
    UsersService usersService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return usersService.findAll();
    }

    @POST
    public Response createUser(User user) {
        return usersService.createUser(user);
    }

    @DELETE
    @Path("/{id_user}")
    public Response deleteUser(@PathParam("id_user") String id_user) {
        return usersService.deleteUser(id_user);
    }

    @GET
    @Path("/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id_user") String id_user) {
        return usersService.getUserById(id_user);
    }
}
