package com.sistem.cinerate_api.service.pelicula;

import com.sistem.cinerate_api.dtos.pelicula.PeliculaRequest;
import com.sistem.cinerate_api.dtos.pelicula.PeliculaResponse;
import com.sistem.cinerate_api.entities.Categoria;
import com.sistem.cinerate_api.entities.Pelicula;
import com.sistem.cinerate_api.exception.custom.RecursoNoEncontradoException;
import com.sistem.cinerate_api.mapper.PeliculaMapper;
import com.sistem.cinerate_api.repository.CategoriaRepository;
import com.sistem.cinerate_api.repository.PeliculaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;
    private final CategoriaRepository categoriaRepository;
    private final PeliculaMapper peliculaMapper;

    public PeliculaImpl(PeliculaRepository peliculaRepository,
                        CategoriaRepository categoriaRepository,
                        PeliculaMapper peliculaMapper) {
        this.peliculaRepository = peliculaRepository;
        this.categoriaRepository = categoriaRepository;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    public Page<PeliculaResponse> listarPeliculas(Pageable pageable) {
        return peliculaRepository.findAll(pageable)
                .map(peliculaMapper::toResponse);
    }

    @Override
    public PeliculaResponse crearPelicula(PeliculaRequest datos) {
        Pelicula pelicula = peliculaMapper.toEntity(datos);

        if (datos.getCategoriaIds() != null && !datos.getCategoriaIds().isEmpty()) {
            List<Categoria> categorias = categoriaRepository.findAllById(datos.getCategoriaIds());
            pelicula.setCategorias(categorias);
        }

        peliculaRepository.save(pelicula);
        return peliculaMapper.toResponse(pelicula);
    }

    @Override
    public Page<PeliculaResponse> listarTopPeliculas(Pageable pageable) {
        return peliculaRepository.findAllByOrderByCalificacionPromedioDesc(pageable)
                .map(peliculaMapper::toResponse);
    }

    @Override
    public PeliculaResponse obtenerPelicula(Long id) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Película no encontrada con id: " + id));
        return peliculaMapper.toResponse(pelicula);
    }

    @Override
    public Page<PeliculaResponse> listarPorCategoria(Long categoriaId, Pageable pageable) {
        if (!categoriaRepository.existsById(categoriaId)) {
            throw new RecursoNoEncontradoException("Categoría no encontrada con id: " + categoriaId);
        }
        return peliculaRepository.findByCategoria_id(categoriaId, pageable)
                .map(peliculaMapper::toResponse);
    }

    @Override
    public PeliculaResponse actualizarPelicula(Long id, PeliculaRequest datos) {
        Pelicula pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Película no encontrada con id: " + id));

        pelicula.setTitulo(datos.getTitulo());
        pelicula.setDescripcion(datos.getDescripcion());
        pelicula.setAnio(datos.getAnio());
        pelicula.setDuracion(datos.getDuracion());

        if (datos.getCategoriaIds() != null && !datos.getCategoriaIds().isEmpty()) {
            List<Categoria> categorias = categoriaRepository.findAllById(datos.getCategoriaIds());
            pelicula.setCategorias(categorias);
        }

        peliculaRepository.save(pelicula);
        return peliculaMapper.toResponse(pelicula);
    }

    @Override
    public void eliminarPelicula(Long id) {
        if (!peliculaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Película no encontrada con id: " + id);
        }
        peliculaRepository.deleteById(id);
    }
}
