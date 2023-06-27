package org.example.Service;

import org.example.Model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User createUser(User user);

    boolean deleteUser(Long id_user);

    User getUserById(Long id_user);
}
