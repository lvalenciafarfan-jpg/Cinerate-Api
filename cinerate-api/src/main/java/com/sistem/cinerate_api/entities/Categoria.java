package com.sistem.cinerate_api.entities;

import com.sistem.cinerate_api.enums.CategoriaName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    @Enumerated(EnumType.STRING)
    private CategoriaName nombre;

    @ManyToMany(mappedBy = "categorias")
    private List<Pelicula> peliculas;
}
