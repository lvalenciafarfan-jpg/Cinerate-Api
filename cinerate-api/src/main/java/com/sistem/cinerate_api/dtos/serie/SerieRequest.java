package com.sistem.cinerate_api.dtos.serie;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SerieRequest {

    @NotBlank(message = "El titulo es obligatorio.")
    @Size(min = 3, max = 15, message = "El titulo debe estar entre el rango de 3-15 caracteres.")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria.")
    @Size(min = 40, max = 900, message = "La descripcion debe estar entre el rango de 40-900 caracteres.")
    private String descripcion;

    @NotNull(message = "El año es necesario.")
    private LocalDate anio;

    @NotNull(message = "Las temporadas son obligatorias")
    @Min(value = 1, message = "Una serie debe tener como minimo 1 temporada.")
    @Max(value = 15, message = "Una serie debe tener como maximo 15 temporadas.")
    private Integer temporadas;
}
