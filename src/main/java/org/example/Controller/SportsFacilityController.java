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
    public Response deleteSportsFacility(@PathParam("id_sports_facility") String id_sports_facility) {
        return sportsFacilityService.deleteSportsFacility(id_sports_facility);
    }

    @GET
    @Path("/{id_sports_facility}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityById(@PathParam("id_sports_facility") String id_sports_facility) {
        return sportsFacilityService.getSportsFacilityById(id_sports_facility);
    }
}
