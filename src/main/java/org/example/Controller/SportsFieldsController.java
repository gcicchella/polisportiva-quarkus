package org.example.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import org.example.Service.SportsFieldsService;

@Path("/api/sportsFields")
public class SportsFieldsController {

    @Inject
    SportsFieldsService sportsFieldsService;

}
