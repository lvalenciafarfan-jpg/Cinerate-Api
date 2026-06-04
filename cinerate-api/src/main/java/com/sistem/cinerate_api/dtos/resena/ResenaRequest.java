package com.sistem.cinerate_api.dtos.resena;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ResenaRequest {

    @NotBlank(message = "El contenido es obligatorio.")
    @Size(min = 20, max = 500, message = "El contenido de la reseña debe ser min " + "20 caracteres y max 500.")
    private String contenido;

    @NotNull(message = "La calificacion es obligatoria")
    @Digits(integer = 1, fraction = 1, message = "El entero debe ser 1, y el decimal igual.")
    @DecimalMin(value = "0.0", message = "La calificacion debe ser minimo 0.0")
    @DecimalMax(value = "5.0", message = "La calificacion debe ser de maximo 5.0")
    private BigDecimal calificacion;
}
