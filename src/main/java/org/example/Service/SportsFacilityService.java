package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFacility;

public interface SportsFacilityService {

    Response findAll();

    Response createSportsFacility(SportsFacility sportsFacility);

    Response deleteSportsFacility(String id_sports_facility);

    Response getSportsFacilityById(String id_sports_facility);
}
