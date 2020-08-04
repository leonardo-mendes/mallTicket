package com.ticket.example.service;

import com.ticket.example.domain.UserCheckIn;
import java.time.LocalDateTime;

public interface UserCheckInService {
    void registerCheckIn(Integer userId);

    Iterable<UserCheckIn> findBetween(LocalDateTime start, LocalDateTime end);

    Iterable<UserCheckIn> findAll();
}
