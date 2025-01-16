package jdch.foro.foroAlura.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdch.foro.foroAlura.domain.perfil.Rol;

public record DatosCrearUsuario(
        @NotBlank (message = "El campo Usuario no puede estar vacio")
        String usuario,
        @Email
        @NotBlank (message = "El campo Email no puede estar vacio")
        String email,
        @NotBlank
        String contrasena,
        Rol rol
) {
}
