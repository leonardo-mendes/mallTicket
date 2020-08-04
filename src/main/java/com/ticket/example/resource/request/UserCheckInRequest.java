package com.ticket.example.resource.request;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCheckInRequest {

    @NotNull(message = "0000000000002")
    private String start;

    @NotNull(message = "0000000000002")
    private String end;
}
