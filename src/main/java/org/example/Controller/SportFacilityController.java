package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportFacility;
import org.example.Model.SportField;
import org.example.Model.User;
import org.example.Service.SportFacilityService;
import org.example.Service.UserService;

import java.util.List;

@Path("/api/sports-facilities")
public class SportFacilityController {

    @Inject
    SportFacilityService sportFacilityService;

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try{
            List<SportFacility> sportFacilityList = sportFacilityService.findAll();
            if(sportFacilityList.size() != 0){
                return Response.ok(sportFacilityList).build();
            }
            return Response.serverError().entity("Impianti sportivi non trovati").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @POST
    public Response createSportsFacility(SportFacility sportFacility) {
        try {
            if(userService.getUserById(sportFacility.getUser().getId()) != null) {
               SportFacility sportFacility1 = sportFacilityService.createSportsFacility(sportFacility);
                if(sportFacility1 != null){
                    return Response.ok(sportFacility1).build();
                }
                return Response.serverError().entity("Impianto sportivo non creato").build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Impianto sportivo non creato").build();
        }
    }

    @POST
    @Path("/{id_sports_facility}/sports-fields")
    public Response createSportsFieldBySportsFacility(@PathParam("id_sports_facility") Long id_sports_facility, SportField sportField) {
        try {
            SportFacility sportFacility = sportFacilityService.getSportsFacilityById(id_sports_facility);
            if (sportFacility != null) {
                SportField sportField1 = sportFacilityService.createSportsFieldBySportsFacility(sportFacility, sportField);
                if(sportField1 != null) return Response.ok(sportField1).build();
                return Response.serverError().entity("Campo sportivo non creato").build();
            }
            return Response.serverError().entity("Impianto sportivo non trovato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Campo sportivo non creato").build();
        }
    }

    @DELETE
    @Path("/{id_sports_facility}")
    public Response deleteSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        try {
            if(sportFacilityService.deleteSportsFacilityById(id_sports_facility)){
                return Response.ok("Impianto sportivo eliminato").build();
            }
            return Response.serverError().entity("Impianto sportivo non eliminato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Impianto sportivo non eliminato").build();
        }
    }

//    ToDo: accorpare con findAll
    @GET
    @Path("/getSportsFacilityByUserId/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityByUserId(@PathParam("id_user") Long id_user) {
        try {
            User user = userService.getUserById(id_user);
            if (user != null){
                List<SportFacility> sportFacilityList = sportFacilityService.getSportsFacilityByUserId(id_user);
                if(sportFacilityList.size() != 0){
                    return Response.ok(sportFacilityList).build();
                }
                return Response.serverError().entity("Impianti sportivi non trovati").build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @GET
    @Path("/{id_sports_facility}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        try{
            SportFacility sportFacility = sportFacilityService.getSportsFacilityById(id_sports_facility);
            if(sportFacility != null){
                return Response.ok(sportFacility).build();
            }
            return Response.serverError().entity("Impianto sportivo non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

//    @GET
//    @Path("/sports-facilities/{id_sports_facility}/reservations-summaries")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getReservationSummaries(@PathParam("id_sports_facility") Long id_sports_facility, @QueryParam("start_date") ZonedDateTime startDate, @QueryParam("end_date") ZonedDateTime endDate) {
//        return sportsFacilityService.getReservationSummaries(id_sports_facility, startDate, endDate);
//    }

}
