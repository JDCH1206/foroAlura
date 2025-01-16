package jdch.foro.foroAlura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearTopico (
        @NotBlank
        String tituloTopico,
        @NotBlank
        String mensajeTopico,
        @NotNull
        Long idAutorTopico,
        @NotNull
        Long idCursoTopico
) {
}
