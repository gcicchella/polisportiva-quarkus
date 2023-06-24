package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.SportsField;

public interface SportsFieldsService {

    Response findAll();

    Response createSportsField(SportsField sportsField);

    Response deleteSportsFieldById(Long id_sports_fields);

    Response getSportsFieldsById(Long id_sports_fields);

    Response findByUserIdAndSport(Long id_user, String sport);
}
