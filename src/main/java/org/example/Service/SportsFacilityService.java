package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFacility;
import org.example.Model.SportsField;

import java.time.ZonedDateTime;

public interface SportsFacilityService {

    Response findAll();

    Response createSportsFacility(SportsFacility sportsFacility);

    Response createSportsFieldBySportsFacility(Long id_sports_facility, SportsField sportsField);

    Response deleteSportsFacilityById(Long id_sports_facility);

    Response getSportsFacilityByUserId(Long id_user);

    Response getSportsFacilityById(Long id_sports_facility);

//    Response getReservationSummaries(Long id_sports_facility, ZonedDateTime startDate, ZonedDateTime endDate);
}