package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Model.User;
import org.example.Repository.UsersRepository;

import java.util.List;

@Singleton
public class UsersServiceImplementation implements UsersService{
    @Inject
    private UsersRepository usersRepository;

    @Override
    public List<User> findAll() {
        return usersRepository.listAll();
    }
}



