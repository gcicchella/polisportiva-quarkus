package org.example.Service;

import org.example.Altro.DTO.ReservationSummaryDTO;
import org.example.Model.SportFacility;
import org.example.Model.SportField;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public interface SportFacilityService {

    List<SportFacility> findAll();

    SportFacility createSportsFacility(SportFacility sportFacility);

    SportField createSportsFieldBySportsFacility(SportFacility sportFacility, SportField sportField);

    boolean deleteSportsFacilityById(Long id_sports_facility);

    List<SportFacility> getSportsFacilityByUserId(Long id_user);

    SportFacility getSportsFacilityById(Long id_sports_facility);

    ReservationSummaryDTO getReservationSummaries(Long id_sports_facility, Date startDate, Date endDate);
}