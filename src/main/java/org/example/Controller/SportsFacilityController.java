package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFacility;
import org.example.Service.SportsFacilityService;

@Path("/api/sportsFacility")
public class SportsFacilityController {

    @Inject
    SportsFacilityService sportsFacilityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return sportsFacilityService.findAll();
    }

    @POST
    public Response createSportsFacility(SportsFacility sportsFacility) {
        return sportsFacilityService.createSportsFacility(sportsFacility);
    }

    @DELETE
    @Path("/{id_sports_facility}")
    public Response deleteSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportsFacilityService.deleteSportsFacilityById(id_sports_facility);
    }

    @GET
    @Path("/getSportsFacilityByUserId/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityByUserId(@PathParam("id_user") Long id_user) {
        return sportsFacilityService.getSportsFacilityByUserId(id_user);
    }

    @GET
    @Path("/getSportsFacilityById/{id_sports_facility}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportsFacilityService.getSportsFacilityById(id_sports_facility);
    }
}
