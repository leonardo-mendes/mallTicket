package com.ticket.example.service.impl;

import com.ticket.example.domain.Invoice;
import com.ticket.example.repository.InvoiceRepository;
import com.ticket.example.resource.request.InvoiceRequest;
import com.ticket.example.service.InvoiceService;
import com.ticket.example.service.UserBalanceService;
import com.ticket.example.service.UserCheckInService;
import com.ticket.example.service.UserService;
import java.time.LocalDateTime;
import java.util.Optional;
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
    public Invoice insert(InvoiceRequest invoiceRequest) {
        try {
            userService
                    .findById(invoiceRequest.getUser())
                    .ifPresentOrElse(
                            user ->
                                    registerCheckAndUpdateBalance(
                                            invoiceRequest.getUser(), invoiceRequest.getValue()),
                            Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Invoice invoice = saveInvoice(invoiceRequest);
        log.info(
                "Created invoice number {}, for user {}.",
                invoice.getNumber(),
                invoice.getUserId());
        return invoice;
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
    public Optional<Invoice> findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    @Override
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }
}
