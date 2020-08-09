package com.ticket.example.resource;

import com.ticket.example.aspect.annotation.LogExecutionTime;
import com.ticket.example.resource.response.UserBalanceResponse;
import com.ticket.example.service.UserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/balances")
@RequiredArgsConstructor
public class UserBalanceResource {

    private final UserBalanceService userBalanceService;

    @GetMapping(path = "/{userId}")
    @LogExecutionTime
    UserBalanceResponse findById(@PathVariable(value = "userId") final Integer userId) {
        return userBalanceService.findByUser(userId);
    }
}
