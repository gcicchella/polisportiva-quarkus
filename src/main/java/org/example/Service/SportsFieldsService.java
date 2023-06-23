package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsField;

public interface SportsFieldsService {

    Response findAll();

    Response createSportsFields(SportsField sportsField);

    Response deleteSportsFields(String id_sports_fields);

    Response getSportsFieldsById(String id_sports_fields);
}
