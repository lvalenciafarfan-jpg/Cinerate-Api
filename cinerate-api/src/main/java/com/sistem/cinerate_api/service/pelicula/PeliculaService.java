package com.sistem.cinerate_api.service.pelicula;

import com.sistem.cinerate_api.dtos.pelicula.PeliculaRequest;
import com.sistem.cinerate_api.dtos.pelicula.PeliculaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeliculaService {

    Page<PeliculaResponse> listarPeliculas(Pageable pageable);

    PeliculaResponse crearPelicula(PeliculaRequest datos);

    Page<PeliculaResponse> listarTopPeliculas(Pageable pageable);

    PeliculaResponse obtenerPelicula(Long id);

    Page<PeliculaResponse> listarPorCategoria(Long categoria_id, Pageable pageable);

    PeliculaResponse actualizarPelicula(Long id, PeliculaRequest datos);

    void eliminarPelicula(Long id);

}
