package com.ticket.example.resource.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    @NotBlank(message = "0000000000002")
    private String number;

    @NotNull(message = "0000000000002")
    @Positive(message = "0000000000003")
    private Double value;

    @NotNull(message = "0000000000002")
    private Integer user;
}
