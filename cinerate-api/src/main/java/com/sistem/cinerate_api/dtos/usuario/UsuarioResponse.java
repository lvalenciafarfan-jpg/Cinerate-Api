package com.sistem.cinerate_api.dtos.usuario;

import com.sistem.cinerate_api.enums.RolUsuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponse {

    private Long id;

    private String nombre;

    private Boolean activo;

    private RolUsuario rol;
}
