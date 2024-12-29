package com.example.foroHub.service;

import com.example.foroHub.model.user.User;
import com.example.foroHub.model.user.dto.DtoUpdateUser;
import com.example.foroHub.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAllUsers(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user, DtoUpdateUser data){
        if(data.username() != null) user.setUsername(data.username());
        if(data.email() != null) user.setEmail(data.email());
        if(data.password() != null) user.setPassword(data.password());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
