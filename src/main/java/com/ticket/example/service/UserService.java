package com.ticket.example.service;

import com.ticket.example.resource.request.UserRequest;
import com.ticket.example.resource.response.UserResponse;
import java.util.List;

public interface UserService {
    UserResponse insert(UserRequest user);

    UserResponse findById(Integer userId);

    List<UserResponse> findAll();
}
