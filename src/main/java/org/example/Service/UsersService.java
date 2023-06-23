package org.example.Service;

import jakarta.ws.rs.core.Response;
import org.example.Model.User;

public interface UsersService {
    Response findAll();

    Response createUser(User user);

    Response deleteUser(Long id_user);

    Response getUserById(Long id_user);
}
