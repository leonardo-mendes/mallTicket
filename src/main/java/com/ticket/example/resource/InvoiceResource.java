package com.ticket.example.resource;

import static org.springframework.http.HttpStatus.CREATED;

import com.ticket.example.domain.Invoice;
import com.ticket.example.resource.request.InvoiceRequest;
import com.ticket.example.service.InvoiceService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/invoices")
@RequiredArgsConstructor
public class InvoiceResource {

    private final InvoiceService invoiceService;

    @PostMapping
    @ResponseStatus(code = CREATED)
    Invoice insert(@RequestBody InvoiceRequest invoice) {
        return invoiceService.insert(invoice);
    }

    @GetMapping(path = "/{invoiceId}")
    Optional<Invoice> findById(@PathVariable(value = "invoiceId") final Integer invoiceId) {
        return invoiceService.findById(invoiceId);
    }

    @GetMapping
    Iterable<Invoice> findAll() {
        return invoiceService.findAll();
    }
}
