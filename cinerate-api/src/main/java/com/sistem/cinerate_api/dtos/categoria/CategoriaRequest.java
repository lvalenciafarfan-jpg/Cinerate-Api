package com.sistem.cinerate_api.dtos.categoria;

import com.sistem.cinerate_api.enums.CategoriaName;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoriaRequest {

    @NotNull(message = "El nombre es obligatorio")
    private CategoriaName nombre;
}
