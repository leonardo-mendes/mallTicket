package com.ticket.example.resource;

import static org.springframework.http.HttpStatus.CREATED;

import com.ticket.example.aspect.annotation.LogExecutionTime;
import com.ticket.example.resource.request.InvoiceRequest;
import com.ticket.example.resource.response.InvoiceResponse;
import com.ticket.example.service.InvoiceService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/invoices")
@RequiredArgsConstructor
public class InvoiceResource {

    private final InvoiceService invoiceService;

    @PostMapping
    @LogExecutionTime
    @ResponseStatus(code = CREATED)
    InvoiceResponse insert(@Valid @RequestBody InvoiceRequest invoice) {
        return invoiceService.insert(invoice);
    }

    @GetMapping(path = "/{invoiceId}")
    @LogExecutionTime
    InvoiceResponse findById(@PathVariable(value = "invoiceId") final Integer invoiceId) {
        return invoiceService.findById(invoiceId);
    }

    @GetMapping
    @LogExecutionTime
    Iterable<InvoiceResponse> findAll() {
        return invoiceService.findAll();
    }
}
