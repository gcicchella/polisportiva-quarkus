package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportFacility;
import org.example.Model.SportField;

public interface SportFacilityService {

    Response findAll();

    Response createSportsFacility(SportFacility sportFacility);

    Response createSportsFieldBySportsFacility(Long id_sports_facility, SportField sportField);

    Response deleteSportsFacilityById(Long id_sports_facility);

    Response getSportsFacilityByUserId(Long id_user);

    Response getSportsFacilityById(Long id_sports_facility);

//    Response getReservationSummaries(Long id_sports_facility, ZonedDateTime startDate, ZonedDateTime endDate);
}