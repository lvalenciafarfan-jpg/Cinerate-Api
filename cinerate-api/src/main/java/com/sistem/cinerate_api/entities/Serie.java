package com.sistem.cinerate_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @NotNull(message = "La calificacionPromedido es obligatoria.")
    @Digits(integer = 1, fraction = 1, message = "El entero debe ser 1, y el decimal igual.")
    @DecimalMin(value = "0.0", message = "El valor minimo es 0.0")
    @DecimalMax(value = "5.0", message = "El valor maximo es 5.0")
    private BigDecimal calificacionPromedio;

    @OneToMany(mappedBy = "serie")
    private List<Resena> resenas;

    @ManyToMany
    @JoinTable(
            name = "serie_categoria",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;
}
