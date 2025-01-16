package jdch.foro.foroAlura.domain.respuesta;

import jakarta.validation.constraints.NotNull;


public record DatosCrearRespuesta(
        @NotNull
        String mensajeRespuesta,
        @NotNull
        Long topicoRespuestaId,
        @NotNull
        Long autorRespuestaId)
         {
}
