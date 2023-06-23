package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.example.Model.Address;
import org.example.Model.SportsFacility;
import org.example.Model.User;
import org.example.Repository.AddressRepository;
import org.example.Repository.SportsFacilityRepository;
import org.example.Repository.UsersRepository;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.findById;

@Singleton
public class SportsFacilityServiceImplementation implements SportsFacilityService {

    @Inject
    private SportsFacilityRepository sportsFacilityRepository;

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private AddressRepository addressRepository;

    @Override
    public Response findAll() {
        try{
            List<SportsFacility> sportsFacilityList = sportsFacilityRepository.listAll();
            return Response.ok(sportsFacilityList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    public Response createSportsFacility(SportsFacility sportsFacility) {
        try {
            sportsFacilityRepository.persist(sportsFacility);
            return Response.ok("Impianto sportivo creato").build();
        } catch (Exception e) {
            return Response.serverError().entity("Impianto sportivo non creato").build();
        }
    }

    @Transactional
    @Override
    public Response deleteSportsFacilityById(Long id_sports_facility) {
        try {
            Boolean response = sportsFacilityRepository.deleteById(id_sports_facility);
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
            User user = usersRepository.findById(id_user);
            if (user != null){
                List<SportsFacility> sportsFacility = sportsFacilityRepository.getSportsFacilityByUserId(id_user);
                if(sportsFacility == null) return Response.status(404).entity("Impianto sportivo non associato a nessun utente").build();
                return Response.ok(sportsFacility).build();
            }
            return Response.serverError().entity("Utente non trovato").build();
        }
        catch (Exception e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Transactional
    public Response getSportsFacilityById(Long id_sports_facility) {
        try{
            SportsFacility sportsFacility = sportsFacilityRepository.findById(id_sports_facility);
            if(sportsFacility == null) return Response.status(404).entity("Impianto sportivo non trovato").build();
            return Response.ok(sportsFacility).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }
}
