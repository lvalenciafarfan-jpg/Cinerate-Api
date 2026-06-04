package com.sistem.cinerate_api.dtos.resena;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ResenaResponse {

    private String contenido;

    private BigDecimal calificacion;

    private LocalDateTime fecha;
}
