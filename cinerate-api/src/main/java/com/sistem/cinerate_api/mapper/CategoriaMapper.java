package com.sistem.cinerate_api.mapper;

import com.sistem.cinerate_api.dtos.categoria.CategoriaRequest;
import com.sistem.cinerate_api.dtos.categoria.CategoriaResponse;
import com.sistem.cinerate_api.entities.Categoria;

public class CategoriaMapper {

    public Categoria ToEntity(CategoriaRequest datos){
        Categoria categoria = new Categoria();
        categoria.setNombre(datos.getNombre());

        return categoria;
    }

    public CategoriaResponse ToResponse(Categoria categoria){
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        categoriaResponse.setNombre(categoria.getNombre());

        return categoriaResponse;
    }

}
