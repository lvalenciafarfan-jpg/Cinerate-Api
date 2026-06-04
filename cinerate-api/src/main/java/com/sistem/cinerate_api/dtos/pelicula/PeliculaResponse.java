package com.sistem.cinerate_api.dtos.pelicula;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PeliculaResponse {

    private String titulo;

    private String descripcion;

    private LocalDate anio;

    private Integer duracion;

    private BigDecimal calificacionPromedio;
}
