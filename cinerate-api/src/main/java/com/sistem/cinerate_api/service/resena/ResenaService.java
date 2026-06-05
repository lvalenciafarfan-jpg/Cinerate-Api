package com.sistem.cinerate_api.service.resena;

import com.sistem.cinerate_api.dtos.resena.ResenaRequest;
import com.sistem.cinerate_api.dtos.resena.ResenaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResenaService {

    ResenaResponse crearResenaEnPelicula(Long peliculaId, Long usuarioId, ResenaRequest request);

    ResenaResponse crearResenaEnSerie(Long serieId, Long usuarioId, ResenaRequest request);

    Page<ResenaResponse> listarPorPelicula(Long peliculaId, Pageable pageable);

    Page<ResenaResponse> listarPorSerie(Long serieId, Pageable pageable);

    Page<ResenaResponse> listarPorUsuario(Long usuarioId, Pageable pageable);

    void eliminarResena(Long resenaId);
}
