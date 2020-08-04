package com.ticket.example.service;

import com.ticket.example.resource.request.InvoiceRequest;
import com.ticket.example.resource.response.InvoiceResponse;

public interface InvoiceService {
    InvoiceResponse insert(InvoiceRequest invoice);

    InvoiceResponse findById(Integer invoiceId);

    Iterable<InvoiceResponse> findAll();
}
