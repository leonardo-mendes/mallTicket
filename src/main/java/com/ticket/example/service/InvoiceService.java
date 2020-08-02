package com.ticket.example.service;

import com.ticket.example.domain.Invoice;
import com.ticket.example.resource.request.InvoiceRequest;
import java.util.Optional;

public interface InvoiceService {
    Invoice insert(InvoiceRequest invoice);

    Optional<Invoice> findById(Integer invoiceId);

    Iterable<Invoice> findAll();
}
