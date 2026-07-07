package com.sistem.cinerate_api.mapper;

import com.sistem.cinerate_api.dtos.pelicula.PeliculaRequest;
import com.sistem.cinerate_api.dtos.pelicula.PeliculaResponse;
import com.sistem.cinerate_api.entities.Pelicula;

public class PeliculaMapper {

    public Pelicula toEntity(PeliculaRequest datos){
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(datos.getTitulo());
        pelicula.setAnio(datos.getAnio());
        pelicula.setDuracion(datos.getDuracion());
        pelicula.setDescripcion(datos.getDescripcion());

        return pelicula;
    }

    public PeliculaResponse toResponse(Pelicula pelicula){
        PeliculaResponse peliculaResponse = new PeliculaResponse();
        peliculaResponse.setAnio(pelicula.getAnio());
        peliculaResponse.setTitulo(pelicula.getTitulo());
        peliculaResponse.setDescripcion(pelicula.getDescripcion());
        peliculaResponse.setDuracion(pelicula.getDuracion());
        peliculaResponse.setCalificacionPromedio(pelicula.getCalificacionPromedio());

        return peliculaResponse;
    }
}
