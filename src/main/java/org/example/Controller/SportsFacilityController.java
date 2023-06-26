package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFacility;
import org.example.Model.SportsField;
import org.example.Service.SportsFacilityService;
import org.jboss.resteasy.annotations.Body;

@Path("/api/sports-facilities")
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

    @POST
    @Path("/{id_sports_facility}/sports-fields")
    public Response createSportsFieldBySportsFacility(@PathParam("id_sports_facility") Long id_sports_facility, SportsField sportsField) {
        return sportsFacilityService.createSportsFieldBySportsFacility(id_sports_facility, sportsField);
    }

    @DELETE
    @Path("/{id_sports_facility}")
    public Response deleteSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportsFacilityService.deleteSportsFacilityById(id_sports_facility);
    }

//    ToDo: accorpare con findAll
    @GET
    @Path("/getSportsFacilityByUserId/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityByUserId(@PathParam("id_user") Long id_user) {
        return sportsFacilityService.getSportsFacilityByUserId(id_user);
    }

    @GET
    @Path("/{id_sports_facility}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportsFacilityService.getSportsFacilityById(id_sports_facility);
    }
}
