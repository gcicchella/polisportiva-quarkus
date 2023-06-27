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
    public List<SportField> findAll() {
        return sportFieldRepository.listAll();
    }

    @Transactional
    @Override
    public boolean deleteSportsFieldById(Long id_sports_fields) {
        return sportFieldRepository.deleteById(id_sports_fields);
    }

    @Override
    public SportField getSportsFieldsById(Long id_sports_fields) {
        return sportFieldRepository.findById(id_sports_fields);
    }

    @Override
    public List<SportField> findByUserIdAndSport(Long id_user, String sport) {
        List<SportField> sportFields = null;
        if (id_user != null && sport != null) {
            return sportFields = sportFieldRepository.find("user.id = ?1 and sport = ?2", id_user, sport).list();
        } else if (id_user != null) {
            return sportFields = sportFieldRepository.find("user.id = ?1", id_user).list();
        } else if (sport != null) {
            return sportFields = sportFieldRepository.find("sport = ?1", sport).list();
        } else {
            return sportFields = sportFieldRepository.listAll();
        }
    }

//    @Override
//    public Response findByUserIdAndSport(Long id_user, String sport) {
//        try {
//            List<SportField> sportFields = null;
//            if (id_user != null && sport != null) {
//                sportFields = sportFieldRepository.find("user.id = ?1 and sport = ?2", id_user, sport).list();
//            } else if (id_user != null) {
//                sportFields = sportFieldRepository.find("user.id = ?1", id_user).list();
//            } else if (sport != null) {
//                sportFields = sportFieldRepository.find("sport = ?1", sport).list();
//            } else {
//                sportFields = sportFieldRepository.listAll();
//            }
//            if (sportFields == null) {
//                return Response.status(404).entity("Campo sportivo non trovato").build();
//            }
//            return Response.ok(sportFields).build();
//        } catch (Exception e) {
//            return Response.serverError().entity("Errore nella ricerca").build();
//        }
//    }

}
