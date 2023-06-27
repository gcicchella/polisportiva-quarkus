package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportFacility;
import org.example.Model.SportField;
import org.example.Service.SportFacilityService;

@Path("/api/sports-facilities")
public class SportFacilityController {

    @Inject
    SportFacilityService sportFacilityService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return sportFacilityService.findAll();
    }

    @POST
    public Response createSportsFacility(SportFacility sportFacility) {
        return sportFacilityService.createSportsFacility(sportFacility);
    }

    @POST
    @Path("/{id_sports_facility}/sports-fields")
    public Response createSportsFieldBySportsFacility(@PathParam("id_sports_facility") Long id_sports_facility, SportField sportField) {
        return sportFacilityService.createSportsFieldBySportsFacility(id_sports_facility, sportField);
    }

    @DELETE
    @Path("/{id_sports_facility}")
    public Response deleteSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportFacilityService.deleteSportsFacilityById(id_sports_facility);
    }

//    ToDo: accorpare con findAll
    @GET
    @Path("/getSportsFacilityByUserId/{id_user}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityByUserId(@PathParam("id_user") Long id_user) {
        return sportFacilityService.getSportsFacilityByUserId(id_user);
    }

    @GET
    @Path("/{id_sports_facility}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportsFacilityById(@PathParam("id_sports_facility") Long id_sports_facility) {
        return sportFacilityService.getSportsFacilityById(id_sports_facility);
    }

//    @GET
//    @Path("/sports-facilities/{id_sports_facility}/reservations-summaries")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getReservationSummaries(@PathParam("id_sports_facility") Long id_sports_facility, @QueryParam("start_date") ZonedDateTime startDate, @QueryParam("end_date") ZonedDateTime endDate) {
//        return sportsFacilityService.getReservationSummaries(id_sports_facility, startDate, endDate);
//    }

}
