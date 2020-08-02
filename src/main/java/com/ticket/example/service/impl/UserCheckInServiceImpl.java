package com.ticket.example.service.impl;

import com.ticket.example.domain.UserCheckIn;
import com.ticket.example.repository.UserCheckInRepository;
import com.ticket.example.service.UserCheckInService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCheckInServiceImpl implements UserCheckInService {

    private final UserCheckInRepository userCheckInRepository;

    @Override
    public void registerCheckIn(Integer userId) {
        Optional.ofNullable(userCheckInRepository.findByUserIdOrderByCreatedAtDesc(userId))
                .ifPresentOrElse(
                        this::checkNewCheckIn,
                        () ->
                                userCheckInRepository.save(
                                        UserCheckIn.builder()
                                                .userId(userId)
                                                .createdAt(LocalDateTime.now())
                                                .build()));
        log.info("Registered check-in for user {}.", userId);
    }

    private void checkNewCheckIn(UserCheckIn userCheckIn) {
        if (moreThan2Minutes(userCheckIn)) {
            userCheckInRepository.save(
                    UserCheckIn.builder()
                            .userId(userCheckIn.getUserId())
                            .createdAt(LocalDateTime.now())
                            .build());
        }
    }

    private boolean moreThan2Minutes(UserCheckIn userCheckIn) {
        return Duration.between(userCheckIn.getCreatedAt(), LocalDateTime.now()).getSeconds() > 120;
    }

    @Override
    public Iterable<UserCheckIn> findAll() {
        return userCheckInRepository.findAll();
    }
}
