package jdch.foro.foroAlura.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosAutenticacionUsuario(
        @NotBlank(message = "El campo login (Usuario a loguear) no puede estar vacio")
        String login,
        @NotBlank (message = "El campo contraseña no puede estar vacio")
        String contrasena
) {
}
