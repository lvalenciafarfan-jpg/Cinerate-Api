package com.sistem.cinerate_api.service.resena;

import com.sistem.cinerate_api.dtos.resena.ResenaRequest;
import com.sistem.cinerate_api.dtos.resena.ResenaResponse;
import com.sistem.cinerate_api.entities.Pelicula;
import com.sistem.cinerate_api.entities.Resena;
import com.sistem.cinerate_api.entities.Serie;
import com.sistem.cinerate_api.entities.Usuario;
import com.sistem.cinerate_api.exception.custom.RecursoNoEncontradoException;
import com.sistem.cinerate_api.exception.custom.ReglaDeNegocioException;
import com.sistem.cinerate_api.mapper.ResenaMapper;
import com.sistem.cinerate_api.repository.PeliculaRepository;
import com.sistem.cinerate_api.repository.ResenaRepository;
import com.sistem.cinerate_api.repository.SerieRepository;
import com.sistem.cinerate_api.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ResenaImpl implements ResenaService {

    private final ResenaRepository resenaRepository;

    private final PeliculaRepository peliculaRepository;

    private final SerieRepository serieRepository;

    private final UsuarioRepository usuarioRepository;

    public ResenaImpl(ResenaRepository resenaRepository, PeliculaRepository peliculaRepository,
                      SerieRepository serieRepository, UsuarioRepository usuarioRepository) {
        this.resenaRepository = resenaRepository;
        this.peliculaRepository = peliculaRepository;
        this.serieRepository = serieRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private Pelicula encontrarPelicula(Long id) {
        return peliculaRepository.findById(id).
                orElseThrow(() -> new RecursoNoEncontradoException("Pelicula no encontrada con id: " + id));
    }

    private Usuario encontrarUsuario(Long id) {
        return usuarioRepository.findById(id).
                orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado con id: " + id));
    }

    private Serie encontrarSerie(Long id) {
        return serieRepository.findById(id).
                orElseThrow(() -> new RecursoNoEncontradoException("Serie no encontrada con id: " + id));
    }

    @Override
    public ResenaResponse crearResenaEnPelicula(Long peliculaId, Long usuarioId, ResenaRequest request) {
        Pelicula pelicula = encontrarPelicula(peliculaId);
        Usuario usuario = encontrarUsuario(usuarioId);

        if (resenaRepository.existsByUsuario_IdAndPelicula_Id(usuarioId, peliculaId)) {
            throw new ReglaDeNegocioException("El usuario ya reseñó esta película.");
        }

        Resena resena = ResenaMapper.ToEntity(request);
        resena.setPelicula(pelicula);
        resena.setUsuario(usuario);

        resenaRepository.save(resena);

        BigDecimal promedio = resenaRepository.calcularPromedioPelicula(peliculaId);
        pelicula.setCalificacionPromedio(promedio);
        peliculaRepository.save(pelicula);

        return ResenaMapper.ToResponse(resena);
    }

    @Override
    public ResenaResponse crearResenaEnSerie(Long serieId, Long usuarioId, ResenaRequest request) {
        Serie serie = encontrarSerie(serieId);
        Usuario usuario = encontrarUsuario(usuarioId);

        if (resenaRepository.existsByUsuario_IdAndSerie_Id(usuarioId, serieId)) {
            throw new ReglaDeNegocioException("El usuario ya reseño esta serie.");
        }

        Resena resena = ResenaMapper.ToEntity(request);
        resena.setSerie(serie);
        resena.setUsuario(usuario);

        resenaRepository.save(resena);

        BigDecimal promedio = resenaRepository.calcularPromedioSerie(serieId);
        serie.setCalificacionPromedio(promedio);
        serieRepository.save(serie);

        return ResenaMapper.ToResponse(resena);
    }

    @Override
    public Page<ResenaResponse> listarPorPelicula(Long peliculaId, Pageable pageable) {
        if (!peliculaRepository.existsById(peliculaId)) {
            throw new ReglaDeNegocioException("Pelicula no encontrada con id: " + peliculaId);
        }

        return resenaRepository.findByPelicula_id(peliculaId, pageable).
                map(ResenaMapper::ToResponse);
    }

    @Override
    public Page<ResenaResponse> listarPorSerie(Long serieId, Pageable pageable) {
        if (!serieRepository.existsById(serieId)) {
            throw new ReglaDeNegocioException("Serie no encontrada con id: " + serieId);
        }

        return resenaRepository.findBySerie_id(serieId, pageable).
                map(ResenaMapper::ToResponse);
    }

    @Override
    public Page<ResenaResponse> listarPorUsuario(Long usuarioId, Pageable pageable) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ReglaDeNegocioException("Usuario no encontrado con id: " + usuarioId);
        }

        return resenaRepository.findByUsuario_Id(usuarioId, pageable).
                map(ResenaMapper::ToResponse);
    }

    @Override
    public void eliminarResena(Long resenaId) {
        Resena resena = resenaRepository.findById(resenaId).
                orElseThrow(() -> new RecursoNoEncontradoException("Resena no encontrada con id: " + resenaId));

        Long peliculaId = resena.getPelicula() != null ? resena.getPelicula().getId() : null;
        Long serieId = resena.getSerie() != null ? resena.getSerie().getId() : null;

        resenaRepository.delete(resena);

        if (peliculaId != null) {
            BigDecimal promedio = resenaRepository.calcularPromedioPelicula(peliculaId);
            Pelicula pelicula = encontrarPelicula(peliculaId);
            pelicula.setCalificacionPromedio(promedio != null ? promedio : BigDecimal.ZERO);
            peliculaRepository.save(pelicula);
        }

        if (serieId != null) {
            BigDecimal promedio = resenaRepository.calcularPromedioSerie(serieId);
            Serie serie = encontrarSerie(serieId);
            serie.setCalificacionPromedio(promedio != null ? promedio : BigDecimal.ZERO);
            serieRepository.save(serie);
        }
    }
}
