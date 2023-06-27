package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportFacility;
import org.example.Model.SportField;
import org.example.Model.User;
import org.example.Repository.SportFacilityRepository;
import org.example.Repository.SportFieldRepository;
import org.example.Repository.UserRepository;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.findById;

@Singleton
public class SportFacilityServiceImplementation implements SportFacilityService {

    @Inject
    private SportFacilityRepository sportFacilityRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private SportFieldRepository sportFieldRepository;

    @Override
    public Response findAll() {
        try{
            List<SportFacility> sportFacilityList = sportFacilityRepository.listAll();
            return Response.ok(sportFacilityList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    public Response createSportsFacility(SportFacility sportFacility) {
        try{
            if(userRepository.findById(sportFacility.getUser().getId()) != null){
                sportFacilityRepository.persist(sportFacility);
                return Response.ok("Impianto sportivo creato").build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Impianto sportivo non creato").build();
        }
    }

    @Transactional
    @Override
    public Response createSportsFieldBySportsFacility(Long id_sports_facility, SportField sportField) {
        try {
           SportFacility sportFacility = sportFacilityRepository.findById(id_sports_facility);
            if(sportFacility != null){
                sportField.setUser(sportFacility.getUser());
                sportField.setSportsFacility(sportFacility);
                sportFieldRepository.persist(sportField);
                return Response.ok("Campo sportivo creato").build();
            }
            return Response.serverError().entity("Impianto sportivo non trovato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Campo sportivo non creato").build();
        }
    }

    @Transactional
    @Override
    public Response deleteSportsFacilityById(Long id_sports_facility) {
        try {
            Boolean response = sportFacilityRepository.deleteById(id_sports_facility);
            String msg = "Impianto sportivo non eliminato";
            if(response){
                msg = "Impianto sportivo eliminato";
            }
            return Response.ok(msg).build();

        } catch (Exception e) {
            return Response.serverError().entity("Impianto sportivo non eliminato").build();
        }
    }

    @Transactional
    @Override
    public Response getSportsFacilityByUserId(@PathParam("id_user") Long id_user) {
        try{
            User user = userRepository.findById(id_user);
            if (user != null){
                List<SportFacility> sportFacility = sportFacilityRepository.getSportsFacilityByUserId(id_user);
                if(sportFacility == null) return Response.status(404).entity("Impianto sportivo non associato a nessun utente").build();
                return Response.ok(sportFacility).build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

    @Transactional
    public Response getSportsFacilityById(Long id_sports_facility) {
        try{
            SportFacility sportFacility = sportFacilityRepository.findById(id_sports_facility);
            if(sportFacility == null) return Response.status(404).entity("Impianto sportivo non trovato").build();
            return Response.ok(sportFacility).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

//    @Override
//    public Response getReservationSummaries(Long id_sports_facility, ZonedDateTime startDate, ZonedDateTime endDate) {
//        return null;
//    }

}
