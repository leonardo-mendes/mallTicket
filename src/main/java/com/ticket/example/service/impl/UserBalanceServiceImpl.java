package com.ticket.example.service.impl;

import com.ticket.example.domain.UserBalance;
import com.ticket.example.repository.UserBalanceRepository;
import com.ticket.example.service.UserBalanceService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserBalanceServiceImpl implements UserBalanceService {

    private final UserBalanceRepository userBalanceRepository;

    @Override
    public void update(Integer userId, Double value) {
        userBalanceRepository
                .findByUserId(userId)
                .ifPresentOrElse(
                        userBalance -> updateBalance(userBalance, value),
                        () -> createBalance(userId, value));
    }

    private void updateBalance(UserBalance userBalance, Double value) {
        userBalanceRepository.save(
                UserBalance.builder()
                        .id(userBalance.getId())
                        .userId(userBalance.getUserId())
                        .updatedAt(LocalDateTime.now())
                        .balance(userBalance.getBalance() + value)
                        .build());
        log.info("Updated balance for user {}.", userBalance.getUserId());
    }

    private void createBalance(Integer userId, Double value) {
        userBalanceRepository.save(
                UserBalance.builder()
                        .userId(userId)
                        .updatedAt(LocalDateTime.now())
                        .balance(value)
                        .build());
        log.info("Created balance for user {}.", userId);
    }

    @Override
    public Optional<UserBalance> findByUser(Integer userId) {
        return userBalanceRepository.findByUserId(userId);
    }
}
