package com.sistem.cinerate_api.repository;

import com.sistem.cinerate_api.entities.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    Page<Pelicula> findAllByOrderByCalificacionPromedioDesc(Pageable pageable);

    Page <Pelicula> findByCategoria_id(Long categoria_id, Pageable pageable);

    Page <Pelicula> findByAnio(Integer anio, Pageable pageable);

    Page <Pelicula> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}
