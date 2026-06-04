package com.sistem.cinerate_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull(message = "La calificacionPromedido es obligatoria.")
    @Digits(integer = 1, fraction = 1, message = "El entero debe ser 1, y el decimal igual.")
    @DecimalMin(value = "0.0", message = "El valor minimo es 0.0")
    @DecimalMax(value = "5.0", message = "El valor maximo es 5.0")
    private BigDecimal calificacionPromedio;

    @OneToMany(mappedBy = "pelicula")
    private List<Resena> resenas;

    @ManyToMany
    @JoinTable(
            name = "pelicula_categoria",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;
}
