package com.ticket.example.service.impl;

import com.ticket.example.domain.User;
import com.ticket.example.repository.UserRepository;
import com.ticket.example.resource.request.UserRequest;
import com.ticket.example.service.UserService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User insert(UserRequest userRequest) {
        User user =
                userRepository.save(
                        User.builder()
                                .name(userRequest.getName())
                                .createdAt(LocalDateTime.now())
                                .build());
        log.info("Created user {}", user.getName());
        return user;
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
