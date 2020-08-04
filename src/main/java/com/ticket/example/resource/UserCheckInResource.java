package com.ticket.example.resource;

import com.ticket.example.domain.UserCheckIn;
import com.ticket.example.resource.request.UserCheckInRequest;
import com.ticket.example.service.UserCheckInService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/check-in")
@RequiredArgsConstructor
public class UserCheckInResource {

    private final UserCheckInService userCheckInService;

    @GetMapping
    Iterable<UserCheckIn> findAll() {
        return userCheckInService.findAll();
    }

    @PostMapping("/between")
    Iterable<UserCheckIn> findBetween(@RequestBody UserCheckInRequest userCheckInRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return userCheckInService.findBetween(
                LocalDateTime.parse(userCheckInRequest.getStart().concat(" 00:00:00"), formatter),
                LocalDateTime.parse(userCheckInRequest.getEnd().concat(" 23:59:59"), formatter));
    }
}
