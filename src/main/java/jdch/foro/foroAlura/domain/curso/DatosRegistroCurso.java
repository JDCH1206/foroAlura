package jdch.foro.foroAlura.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank
        String nombreCurso,
        @NotNull
        CategoriaCurso categoriaCurso
) {
}
