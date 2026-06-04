package com.sistem.cinerate_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El contenido es obligatorio.")
    @Size(min = 20, max = 500, message = "El contenido de la reseña debe ser min " + "20 caracteres y max 500.")
    private String contenido;

    @NotNull(message = "La calificacion es obligatoria")
    @Digits(integer = 1, fraction = 1, message = "El entero debe ser 1, y el decimal igual.")
    @DecimalMin(value = "0.0", message = "La calificacion debe ser minimo 0.0")
    @DecimalMax(value = "5.0", message = "La calificacion debe ser de maximo 5.0")
    private BigDecimal calificacion;

    @NotNull(message = "La fecha es obligatoria.")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
