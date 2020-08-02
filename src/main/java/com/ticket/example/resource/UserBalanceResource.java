package com.ticket.example.resource;

import com.ticket.example.domain.UserBalance;
import com.ticket.example.service.UserBalanceService;
import java.util.Optional;
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
    Optional<UserBalance> findById(@PathVariable(value = "userId") final Integer userId)
            throws Exception {
        return userBalanceService.findByUser(userId);
    }
}
