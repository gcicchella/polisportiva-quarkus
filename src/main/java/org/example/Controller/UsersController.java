package org.example.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.Users;
import org.example.Service.UsersService;

import javax.sql.DataSource;
import java.util.List;

@Path("/db")
public class UsersController {

//    @Inject
//    DataSource dataSource;

    @Inject
    UsersService usersService;

//    @Path("/json")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getUsers() {
//        try {
//            List<Users> users = usersService.findAll();
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(users);
//            return Response.ok(json, MediaType.APPLICATION_JSON).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving user data: " + e.getMessage()).build();
//        }
//    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers2() {
        return usersService.findAll();
    }
}
