package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.Model.Users;
import org.example.Repository.UsersRepository;

import java.util.List;

@Singleton
public class UsersServiceImplementation implements UsersService{
    @Inject
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.listAll();
    }
}



