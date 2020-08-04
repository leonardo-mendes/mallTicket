package com.ticket.example.resource;

import static org.springframework.http.HttpStatus.CREATED;

import com.ticket.example.resource.request.TicketRequest;
import com.ticket.example.service.TicketService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tickets")
@RequiredArgsConstructor
public class TicketResource {

    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    void insert(@Valid @RequestBody TicketRequest ticketRequest) {
        ticketService.insert(ticketRequest);
    }
}
