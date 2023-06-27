package org.example.Service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.example.Model.User;
import org.example.Repository.UserRepository;

import java.util.List;

@Singleton
public class UserServiceImplementation implements UserService {
    @Inject
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
       return userRepository.listAll();
    }

    @Transactional
    public User createUser(User user) {
        userRepository.persist(user);
        User user1 = userRepository.findById(user.getId());
        if(user1 != null){
            return user1;
        }
        else return null;
    }

    @Transactional
    @Override
    public boolean deleteUser(Long id_user) {
        return userRepository.deleteById(id_user);
    }

    @Override
    public User getUserById(Long id_user) {
        return userRepository.findById(id_user);
    }

}



