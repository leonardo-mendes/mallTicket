package com.ticket.example.service.impl;

import com.ticket.example.domain.Ticket;
import com.ticket.example.repository.TicketRepository;
import com.ticket.example.resource.request.TicketRequest;
import com.ticket.example.service.TicketService;
import com.ticket.example.service.UserBalanceService;
import com.ticket.example.service.UserService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final Double TICKET_VALUE = 200.00;
    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final UserBalanceService userBalanceService;

    @Override
    public void insert(TicketRequest ticketRequest) {
        userService
                .findById(ticketRequest.getUserId())
                .ifPresent(user -> insertTicketAndUpdateBalance(user.getId()));
    }

    private void insertTicketAndUpdateBalance(Integer userId) {
        ticketRepository.save(
                Ticket.builder().userId(userId).createdAt(LocalDateTime.now()).build());

        userBalanceService.update(userId, -TICKET_VALUE);
    }
}
