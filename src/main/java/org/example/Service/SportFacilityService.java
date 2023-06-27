package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportFacility;
import org.example.Model.SportField;

import java.util.List;

public interface SportFacilityService {

    List<SportFacility> findAll();

    SportFacility createSportsFacility(SportFacility sportFacility);

    SportField createSportsFieldBySportsFacility(SportFacility sportFacility, SportField sportField);

    boolean deleteSportsFacilityById(Long id_sports_facility);

    List<SportFacility> getSportsFacilityByUserId(Long id_user);

    SportFacility getSportsFacilityById(Long id_sports_facility);

//    Response getReservationSummaries(Long id_sports_facility, ZonedDateTime startDate, ZonedDateTime endDate);
}