package com.sistem.cinerate_api.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private LocalDate año;

    private Integer temporadas;

    private Double calificacionPromedio;

    @OneToMany(mappedBy = "serie")
    private List<Reseña> reseñas;

    @ManyToMany
    @JoinTable(
            name = "serie_categoria",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;
}
