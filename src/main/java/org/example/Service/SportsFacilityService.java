package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFacility;

public interface SportsFacilityService {

    Response findAll();

    Response createSportsFacility(SportsFacility sportsFacility);

    Response deleteSportsFacilityById(Long id_sports_facility);

    Response getSportsFacilityByUserId(Long id_user);

    Response getSportsFacilityById(Long id_sports_facility);
}