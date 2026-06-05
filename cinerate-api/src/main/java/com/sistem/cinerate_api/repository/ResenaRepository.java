package com.sistem.cinerate_api.repository;

import com.sistem.cinerate_api.entities.Resena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ResenaRepository extends JpaRepository <Resena, Long> {

    Page<Resena> findByPelicula_id(Long pelicula_id, Pageable page);

    Page<Resena> findBySerie_id(Long serie_id, Pageable page);

    Page<Resena> findByUsuario_Id(Long usuarioId, Pageable pageable);

    boolean existsByUsuario_IdAndPelicula_Id(Long usuarioId, Long peliculaId);

    boolean existsByUsuario_IdAndSerie_Id(Long usuarioId, Long serieId);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.pelicula.id = :peliculaId")
    BigDecimal calcularPromedioPelicula(@Param("peliculaId") Long peliculaId);

    @Query("SELECT AVG(r.calificacion) FROM Resena r WHERE r.serie.id = :serieId")
    BigDecimal calcularPromedioSerie(@Param("serieId") Long serieId);
}
