package com.sistem.cinerate_api.dtos.pelicula;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PeliculaRequest {

    @NotBlank(message = "el titulo es obligatorio.")
    @Size(min = 3, max = 15, message = "El titulo debe estar entre el rango de 3-15 caracteres.")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria.")
    @Size(min = 40, max = 900, message = "La descripcion debe estar entre el rango de 40-900 caracteres.")
    private String descripcion;

    @NotNull(message = "El año es necesario.")
    private LocalDate anio;

    @NotNull(message = "La duracion es obligatoria")
    @Min(value = 40, message = "La pelicula debe durar minimo 40 minutos")
    @Max(value = 80, message = "La pelicula no debe durar mas de 2 horas.")
    private Integer duracion;
}
