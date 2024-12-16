package org.personalprojects.springsecurity.service;


import org.personalprojects.springsecurity.controller.dto.SignupRequest;
import org.personalprojects.springsecurity.model.User;
import org.personalprojects.springsecurity.repository.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signup(SignupRequest request){
        String email = request.email();
        Optional<User> exstingUser = repository.findById(email);
        if(exstingUser.isPresent()) {
            throw new DuplicateKeyException(String.format("User with email address '%s' already exists.", email));
        }

        String hashedPassword = passwordEncoder.encode(request.password());
        User user = new User(request.name(), email, hashedPassword);
        repository.save(user);
    }

}
