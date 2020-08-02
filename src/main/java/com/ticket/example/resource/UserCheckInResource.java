package com.ticket.example.resource;

import com.ticket.example.domain.UserCheckIn;
import com.ticket.example.service.UserCheckInService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/check-in")
@RequiredArgsConstructor
public class UserCheckInResource {

    private final UserCheckInService userCheckInService;

    @GetMapping
    Iterable<UserCheckIn> findAll() {
        return userCheckInService.findAll();
    }
}
