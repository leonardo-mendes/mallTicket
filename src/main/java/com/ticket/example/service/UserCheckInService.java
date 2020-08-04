package com.ticket.example.service;

import com.ticket.example.resource.response.UserCheckInResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface UserCheckInService {
    void registerCheckIn(Integer userId);

    List<UserCheckInResponse> findBetween(LocalDateTime start, LocalDateTime end);
}
