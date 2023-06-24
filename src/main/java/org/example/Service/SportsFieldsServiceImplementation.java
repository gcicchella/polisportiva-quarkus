package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportsField;
import org.example.Repository.*;

import java.util.List;

@Singleton
public class SportsFieldsServiceImplementation implements SportsFieldsService {

    @Inject
    private SportsFieldRepository sportsFieldRepository;

    @Inject
    private PriceListRepository priceListRepository;

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private SportsFacilityRepository sportsFacilityRepository;

    @Override
    public Response findAll() {
        try{
            List<SportsField> sportsFieldList = sportsFieldRepository.listAll();
            return Response.ok(sportsFieldList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    @Override
    public Response createSportsField(SportsField sportsField) {
        return null;
    }

    @Transactional
    @Override
    public Response deleteSportsFieldById(Long id_sports_fields) {
        try {
            Boolean response = sportsFieldRepository.deleteById(id_sports_fields);
            String msg = "Campo sportivo non eliminato";
            if(response){
                msg = "Campo sportivo eliminato";
            }
            return Response.ok(msg).build();

        } catch (Exception e) {
            return Response.serverError().entity("Campo sportivo non eliminato").build();
        }
    }

    @Override
    public Response getSportsFieldsById(Long id_sports_fields) {
        try{
            SportsField sportsField = sportsFieldRepository.findById(id_sports_fields);
            if(sportsField == null) return Response.status(404).entity("Campo sportivo non trovato").build();
            return Response.ok(sportsField).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

    @Override
    public Response findByUserIdAndSport(Long id_user, String sport) {
        try {
            List<SportsField> sportsFields = null;

            if (id_user != null && sport != null) {
                sportsFields = sportsFieldRepository.find("user.id = ?1 and sport = ?2", id_user, sport).list();
            } else if (id_user != null) {
                sportsFields = sportsFieldRepository.find("user.id = ?1", id_user).list();
            } else if (sport != null) {
                sportsFields = sportsFieldRepository.find("sport = ?1", sport).list();
            } else {
                sportsFields = sportsFieldRepository.listAll();
            }
            if (sportsFields == null) {
                return Response.status(404).entity("Campo sportivo non trovato").build();
            }
            return Response.ok(sportsFields).build();
        } catch (Exception e) {
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

}
