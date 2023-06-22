package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsFields;

public interface SportsFieldsService {

    Response findAll();

    Response createSportsFields(SportsFields sportsFields);

    Response deleteSportsFields(String id_sports_fields);

    Response getSportsFieldsById(String id_sports_fields);
}
