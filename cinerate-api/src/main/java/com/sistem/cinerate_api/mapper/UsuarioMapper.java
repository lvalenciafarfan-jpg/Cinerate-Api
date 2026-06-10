package com.sistem.cinerate_api.mapper;

import com.sistem.cinerate_api.dtos.usuario.UsuarioRequest;
import com.sistem.cinerate_api.dtos.usuario.UsuarioResponse;
import com.sistem.cinerate_api.entities.Usuario;
import com.sistem.cinerate_api.enums.RolUsuario;

public class UsuarioMapper {

    public static Usuario ToEntity(UsuarioRequest request){
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setPassword(request.getPassword());
        usuario.setRol(RolUsuario.USER);
        usuario.setActivo(true);

        return usuario;
    }

    public static UsuarioResponse ToResponse(Usuario usuario){
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuario.getId());
        usuarioResponse.setNombre(usuario.getNombre());
        usuarioResponse.setRol(usuario.getRol());
        usuarioResponse.setActivo(usuario.getActivo());

        return usuarioResponse;
    }

}
