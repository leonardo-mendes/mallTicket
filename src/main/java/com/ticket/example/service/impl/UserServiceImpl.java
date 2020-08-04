package com.ticket.example.service.impl;

import com.ticket.example.domain.User;
import com.ticket.example.error.exceptions.NotFoundException;
import com.ticket.example.repository.UserRepository;
import com.ticket.example.resource.request.UserRequest;
import com.ticket.example.resource.response.UserResponse;
import com.ticket.example.service.UserService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse insert(UserRequest userRequest) {
        User user =
                userRepository.save(
                        User.builder()
                                .name(userRequest.getName())
                                .createdAt(LocalDateTime.now())
                                .build());
        log.info("Created user {}", user.getName());
        return buildResponse(user);
    }

    @Override
    public UserResponse findById(Integer userId) {
        return userRepository
                .findById(userId)
                .map(this::buildResponse)
                .orElseThrow(() -> new NotFoundException(userId.toString()));
    }

    @Override
    public List<UserResponse> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(this::buildResponse)
                .collect(Collectors.toList());
    }

    private UserResponse buildResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
