package com.ticket.example.service;

import com.ticket.example.domain.User;
import com.ticket.example.resource.request.UserRequest;
import java.util.Optional;

public interface UserService {
    User insert(UserRequest user);

    Optional<User> findById(Integer userId);

    Iterable<User> findAll();
}
