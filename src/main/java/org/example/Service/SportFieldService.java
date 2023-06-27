package org.example.Service;

import jakarta.ws.rs.core.Response;

public interface SportFieldService {

    Response findAll();

    Response deleteSportsFieldById(Long id_sports_fields);

    Response getSportsFieldsById(Long id_sports_fields);

    Response findByUserIdAndSport(Long id_user, String sport);
}
