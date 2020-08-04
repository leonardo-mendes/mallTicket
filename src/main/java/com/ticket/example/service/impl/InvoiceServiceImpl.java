package com.ticket.example.service.impl;

import com.ticket.example.domain.Invoice;
import com.ticket.example.error.exceptions.NotFoundException;
import com.ticket.example.repository.InvoiceRepository;
import com.ticket.example.resource.request.InvoiceRequest;
import com.ticket.example.resource.response.InvoiceResponse;
import com.ticket.example.resource.response.UserResponse;
import com.ticket.example.service.InvoiceService;
import com.ticket.example.service.UserBalanceService;
import com.ticket.example.service.UserCheckInService;
import com.ticket.example.service.UserService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserService userService;
    private final UserBalanceService userBalanceService;
    private final UserCheckInService userCheckInService;

    @Override
    @Transactional
    public InvoiceResponse insert(InvoiceRequest invoiceRequest) {
        UserResponse user = userService.findById(invoiceRequest.getUser());
        registerCheckAndUpdateBalance(user.getId(), invoiceRequest.getValue());
        Invoice invoice = saveInvoice(invoiceRequest);
        log.info(
                "Created invoice number {}, for user {}.",
                invoice.getNumber(),
                invoice.getUserId());
        return buildResponse(invoice);
    }

    private void registerCheckAndUpdateBalance(Integer user, Double value) {
        userBalanceService.update(user, value);
        userCheckInService.registerCheckIn(user);
    }

    private Invoice saveInvoice(InvoiceRequest invoiceRequest) {
        return invoiceRepository.save(
                Invoice.builder()
                        .number(invoiceRequest.getNumber())
                        .value(invoiceRequest.getValue())
                        .userId(invoiceRequest.getUser())
                        .createdAt(LocalDateTime.now())
                        .build());
    }

    @Override
    public InvoiceResponse findById(Integer invoiceId) {
        return invoiceRepository
                .findById(invoiceId)
                .map(this::buildResponse)
                .orElseThrow(() -> new NotFoundException(invoiceId.toString()));
    }

    @Override
    public List<InvoiceResponse> findAll() {
        return StreamSupport.stream(invoiceRepository.findAll().spliterator(), false)
                .map(this::buildResponse)
                .collect(Collectors.toList());
    }

    private InvoiceResponse buildResponse(Invoice invoice) {
        return InvoiceResponse.builder()
                .id(invoice.getId())
                .number(invoice.getNumber())
                .userId(invoice.getUserId())
                .createdAt(invoice.getCreatedAt())
                .build();
    }
}
