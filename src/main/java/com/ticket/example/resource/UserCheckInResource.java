package com.ticket.example.resource;

import com.ticket.example.aspect.annotation.LogExecutionTime;
import com.ticket.example.resource.request.UserCheckInRequest;
import com.ticket.example.resource.response.UserCheckInResponse;
import com.ticket.example.service.UserCheckInService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/check-in")
@RequiredArgsConstructor
public class UserCheckInResource {

    private final UserCheckInService userCheckInService;

    @PostMapping("/between")
    @LogExecutionTime
    List<UserCheckInResponse> findBetween(
            @Valid @RequestBody UserCheckInRequest userCheckInRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return userCheckInService.findBetween(
                LocalDateTime.parse(userCheckInRequest.getStart().concat(" 00:00:00"), formatter),
                LocalDateTime.parse(userCheckInRequest.getEnd().concat(" 23:59:59"), formatter));
    }
}
