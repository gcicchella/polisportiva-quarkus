package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Service.SportFieldService;

@Path("/api/sports-fields")
public class SportFieldController {

    @Inject
    SportFieldService sportFieldService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("id_user") Long id_user, @QueryParam("sport") String sport) {
        return sportFieldService.findByUserIdAndSport(id_user, sport);
    }

    @DELETE
    @Path("/{id_sports_fields}")
    public Response deleteSportsFieldById(@PathParam("id_sports_fields") Long id_sports_fields) {
        return sportFieldService.deleteSportsFieldById(id_sports_fields);
    }

    @GET
    @Path("/{id_sports_fields}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFieldsById(@PathParam("id_sports_fields") Long id_sports_fields) {
        return sportFieldService.getSportsFieldsById(id_sports_fields);
    }
}
