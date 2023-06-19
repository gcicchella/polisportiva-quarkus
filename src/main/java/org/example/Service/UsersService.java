package org.example.Service;


import jakarta.ws.rs.core.Response;
import org.example.Model.User;

import java.util.List;

public interface UsersService {
    Response  findAll();

    Response createUser(User user);

    Response deleteUser(String userId);

    Response getUserById(String userId);
}
