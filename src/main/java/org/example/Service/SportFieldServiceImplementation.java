package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.example.Model.SportField;
import org.example.Repository.*;

import java.util.List;

@Singleton
public class SportFieldServiceImplementation implements SportFieldService {

    @Inject
    private SportFieldRepository sportFieldRepository;

    @Override
    public Response findAll() {
        try{
            List<SportField> sportFieldList = sportFieldRepository.listAll();
            return Response.ok(sportFieldList).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore durante la ricerca").build();
        }
    }

    @Transactional
    @Override
    public Response deleteSportsFieldById(Long id_sports_fields) {
        try {
            Boolean response = sportFieldRepository.deleteById(id_sports_fields);
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
            SportField sportField = sportFieldRepository.findById(id_sports_fields);
            if(sportField == null) return Response.status(404).entity("Campo sportivo non trovato").build();
            return Response.ok(sportField).build();
        }
        catch (Exception e){
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

    @Override
    public Response findByUserIdAndSport(Long id_user, String sport) {
        try {
            List<SportField> sportFields = null;

            if (id_user != null && sport != null) {
                sportFields = sportFieldRepository.find("user.id = ?1 and sport = ?2", id_user, sport).list();
            } else if (id_user != null) {
                sportFields = sportFieldRepository.find("user.id = ?1", id_user).list();
            } else if (sport != null) {
                sportFields = sportFieldRepository.find("sport = ?1", sport).list();
            } else {
                sportFields = sportFieldRepository.listAll();
            }
            if (sportFields == null) {
                return Response.status(404).entity("Campo sportivo non trovato").build();
            }
            return Response.ok(sportFields).build();
        } catch (Exception e) {
            return Response.serverError().entity("Errore nella ricerca").build();
        }
    }

}
