package com.sistem.cinerate_api.dtos.serie;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SerieResponse {

    private String titulo;

    private String descripcion;

    private LocalDate anio;

    private Integer temporadas;

    private BigDecimal calificacionPromedio;
}
