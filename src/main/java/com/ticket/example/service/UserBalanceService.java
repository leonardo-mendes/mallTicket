package com.ticket.example.service;

import com.ticket.example.resource.response.UserBalanceResponse;

public interface UserBalanceService {

    void update(Integer userId, Double value);

    UserBalanceResponse findByUser(Integer userId);
}
