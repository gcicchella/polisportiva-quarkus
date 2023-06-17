package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.Model.User;
import org.example.Service.UsersService;

import java.util.List;

@Path("/api")
public class UsersController {

    @Inject
    UsersService usersService;

    @Path("/users")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers2() {
        return usersService.findAll();
    }
}
