package com.sistem.cinerate_api.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private LocalDateTime fecha;
    private String mensaje;
}
