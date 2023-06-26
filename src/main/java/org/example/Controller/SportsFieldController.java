package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportsField;
import org.example.Service.SportsFieldsService;

@Path("/api/sports-fields")
public class SportsFieldController {

    @Inject
    SportsFieldsService sportsFieldsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("id_user") Long id_user, @QueryParam("sport") String sport) {
        return sportsFieldsService.findByUserIdAndSport(id_user, sport);
    }

    @DELETE
    @Path("/{id_sports_fields}")
    public Response deleteSportsFieldById(@PathParam("id_sports_fields") Long id_sports_fields) {
        return sportsFieldsService.deleteSportsFieldById(id_sports_fields);
    }

    @GET
    @Path("/{id_sports_fields}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFieldsById(@PathParam("id_sports_fields") Long id_sports_fields) {
        return sportsFieldsService.getSportsFieldsById(id_sports_fields);
    }
}
