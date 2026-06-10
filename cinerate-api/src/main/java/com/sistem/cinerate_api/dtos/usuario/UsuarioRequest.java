package com.sistem.cinerate_api.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 15)
    private String nombre;

    @NotBlank(message = "La password es obligatoria.")
    private String password;
}
