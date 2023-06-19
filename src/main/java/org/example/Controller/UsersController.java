package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.User;
import org.example.Repository.UsersRepository;
import org.example.Service.UsersService;
import org.jboss.resteasy.annotations.Body;

import java.util.List;

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
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        return usersService.deleteUser(userId);
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") String userId) {
        return usersService.getUserById(userId);
    }
}
