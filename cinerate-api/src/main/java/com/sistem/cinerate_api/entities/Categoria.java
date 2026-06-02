package com.sistem.cinerate_api.entities;

import com.sistem.cinerate_api.enums.CategoriaName;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoriaName nombre;

    @ManyToMany(mappedBy = "categorias")
    private List<Pelicula> peliculas;
}
