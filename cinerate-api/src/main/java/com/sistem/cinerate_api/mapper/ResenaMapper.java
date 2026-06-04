package com.sistem.cinerate_api.mapper;

import com.sistem.cinerate_api.dtos.resena.ResenaRequest;
import com.sistem.cinerate_api.dtos.resena.ResenaResponse;
import com.sistem.cinerate_api.entities.Resena;

import java.time.LocalDateTime;

public class ResenaMapper {

    public Resena ToEntity(ResenaRequest datos){
        Resena resena = new Resena();
        resena.setContenido(datos.getContenido());
        resena.setFecha(LocalDateTime.now());
        resena.setCalificacion(datos.getCalificacion());

        return resena;
    }

    public ResenaResponse ToResponse(Resena resena){
        ResenaResponse resenaResponse = new ResenaResponse();
        resenaResponse.setCalificacion(resena.getCalificacion());
        resenaResponse.setContenido(resena.getContenido());
        resenaResponse.setFecha(LocalDateTime.now());

        return resenaResponse;
    }
}
