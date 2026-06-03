package com.sistem.cinerate_api.entities;
import java.util.List;
import com.sistem.cinerate_api.enums.RolUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 15)
    private String nombre;

    @NotNull(message = "Este campo es obligatorio.")
    private Boolean activo;

    @NotBlank(message = "La password es obligatoria.")
    private String password;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @OneToMany(mappedBy = "usuario")
    private List<Reseña> reseñas;
}
