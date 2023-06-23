package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportsField;
import org.example.Service.SportsFieldsService;

@Path("/api/sportsFields")
public class SportsFieldController {

    @Inject
    SportsFieldsService sportsFieldsService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return sportsFieldsService.findAll();
    }

    @POST
    public Response createSportsFields(SportsField sportsField) {
        return sportsFieldsService.createSportsFields(sportsField);
    }

    @DELETE
    @Path("/{id_sports_fields}")
    public Response deleteSportsFields(@PathParam("id_sports_fields") String id_sports_fields) {
        return sportsFieldsService.deleteSportsFields(id_sports_fields);
    }

    @GET
    @Path("/{id_sports_fields}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFieldsById(@PathParam("id_sports_fields") String id_sports_fields) {
        return sportsFieldsService.getSportsFieldsById(id_sports_fields);
    }
}
