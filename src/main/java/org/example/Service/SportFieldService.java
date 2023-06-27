package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportField;

import java.util.List;

public interface SportFieldService {

    List<SportField> findAll();

    boolean deleteSportsFieldById(Long id_sports_fields);

    SportField getSportsFieldsById(Long id_sports_fields);

    List<SportField> findByUserIdAndSport(Long id_user, String sport);
}
