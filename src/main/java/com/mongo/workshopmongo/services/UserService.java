package com.mongo.workshopmongo.services;

import com.mongo.workshopmongo.domain.User;
import com.mongo.workshopmongo.dto.UserDTO;
import com.mongo.workshopmongo.repositories.UserRepository;
import com.mongo.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}