package com.sistem.cinerate_api.entities;
import java.util.List;
import com.sistem.cinerate_api.enums.RolUsuario;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Boolean activo;

    private String password;

    @Enumerated(EnumType.STRING)
    private RolUsuario rol;

    @OneToMany(mappedBy = "usuario")
    private List<Reseña> reseñas;
}
