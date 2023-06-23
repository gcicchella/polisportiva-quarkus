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
    private SportsFieldsRepository sportsFieldsRepository;

    @Inject
    private PriceListRepository priceListRepository;

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private SportsFacilityRepository sportsFacilityRepository;

    @Override
    public Response findAll() {
        try{
            List<SportsField> sportsFieldList = sportsFieldsRepository.listAll();
            return Response.ok(sportsFieldList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    @Override
    public Response createSportsFields(SportsField sportsField) {
        return null;
    }

    @Transactional
    @Override
    public Response deleteSportsFields(String id_sports_fields) {
        try {
            Boolean response = sportsFieldsRepository.deleteById(id_sports_fields);
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
    public Response getSportsFieldsById(String id_sports_fields) {
        try{
            SportsField sportsField = sportsFieldsRepository.findById(id_sports_fields);
            if(sportsField == null) return Response.status(404).entity("Campo sportivo non trovato").build();
            return Response.ok(sportsField).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }
}
