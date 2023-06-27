package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import org.example.Model.SportFacility;
import org.example.Model.SportField;
import org.example.Repository.SportFacilityRepository;
import org.example.Repository.SportFieldRepository;
import org.example.Repository.UserRepository;

import java.util.List;

@Singleton
public class SportFacilityServiceImplementation implements SportFacilityService {

    @Inject
    private SportFacilityRepository sportFacilityRepository;

    @Inject
    private SportFieldRepository sportFieldRepository;

    @Override
    public List<SportFacility> findAll() {
        return sportFacilityRepository.listAll();
    }

    @Transactional
    public SportFacility createSportsFacility(SportFacility sportFacility) {
        sportFacilityRepository.persist(sportFacility);
        SportFacility sportFacility1 = sportFacilityRepository.findById(sportFacility.getId());
        if(sportFacility1 != null){
            return sportFacility1;
        }
        else return null;
    }

    @Transactional
    @Override
    public SportField createSportsFieldBySportsFacility(SportFacility sportFacility, SportField sportField) {
         sportField.setUser(sportFacility.getUser());
         sportField.setSportsFacility(sportFacility);
         sportFieldRepository.persist(sportField);
         SportField sportField1 = sportFieldRepository.findById(sportField.getId());
         if(sportField1 != null) return sportField1;
         return null;
    }

    @Transactional
    @Override
    public boolean deleteSportsFacilityById(Long id_sports_facility) {
       return sportFacilityRepository.deleteById(id_sports_facility);
    }

    @Transactional
    @Override
    public List<SportFacility> getSportsFacilityByUserId(Long id_user) {
       return sportFacilityRepository.getSportsFacilityByUserId(id_user);
    }

    @Transactional
    public SportFacility getSportsFacilityById(Long id_sports_facility) {
        return sportFacilityRepository.findById(id_sports_facility);
    }

//    @Override
//    public Response getReservationSummaries(Long id_sports_facility, ZonedDateTime startDate, ZonedDateTime endDate) {
//        return null;
//    }

}
