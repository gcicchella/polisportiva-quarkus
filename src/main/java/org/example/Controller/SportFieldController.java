package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportField;
import org.example.Model.User;
import org.example.Service.SportFieldService;

import java.util.List;

@Path("/api/sports-fields")
public class SportFieldController {

    @Inject
    SportFieldService sportFieldService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("id_user") Long id_user, @QueryParam("sport") String sport) {
        try {
            List<SportField> sportFields = sportFieldService.findByUserIdAndSport(id_user, sport);
            if (sportFields != null) {
                return Response.ok(sportFields).build();
            }
            return Response.status(404).entity("Campo sportivo non trovato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

    @DELETE
    @Path("/{id_sports_fields}")
    public Response deleteSportsFieldById(@PathParam("id_sports_fields") Long id_sports_fields) {
        try {
            if(sportFieldService.deleteSportsFieldById(id_sports_fields)){
                return Response.ok("Campo sportivo eliminato").build();
            }
            return Response.serverError().entity("Campo sportivo non eliminato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Campo sportivo non eliminato").build();
        }
    }

    @GET
    @Path("/{id_sports_fields}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFieldsById(@PathParam("id_sports_fields") Long id_sports_fields) {
        try{
            SportField sportField =  sportFieldService.getSportsFieldsById(id_sports_fields);
            if(sportField != null){
                return Response.ok(sportField).build();
            }
            return Response.serverError().entity("Campo sportivo non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }
}
