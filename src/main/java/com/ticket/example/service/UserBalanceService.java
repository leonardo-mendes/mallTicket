package com.ticket.example.service;

import com.ticket.example.domain.UserBalance;
import java.util.Optional;

public interface UserBalanceService {

    void update(Integer userId, Double value);

    Optional<UserBalance> findByUser(Integer userId) throws Exception;
}
