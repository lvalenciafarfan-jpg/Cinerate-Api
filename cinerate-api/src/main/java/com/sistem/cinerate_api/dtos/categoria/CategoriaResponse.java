package com.sistem.cinerate_api.dtos.categoria;

import com.sistem.cinerate_api.enums.CategoriaName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaResponse {

    private CategoriaName nombre;
}
