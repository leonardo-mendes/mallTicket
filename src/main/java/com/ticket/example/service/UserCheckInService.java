package com.ticket.example.service;

import com.ticket.example.domain.UserCheckIn;

public interface UserCheckInService {
    void registerCheckIn(Integer userId);

    Iterable<UserCheckIn> findAll();
}
