package com.sistem.cinerate_api.repository;

import com.sistem.cinerate_api.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
