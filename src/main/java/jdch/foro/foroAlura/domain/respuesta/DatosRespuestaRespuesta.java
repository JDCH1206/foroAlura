package jdch.foro.foroAlura.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuestaRespuesta(
        Long id,
        String mensajeRespuesta,
        String topicoRespuestaTitulo,
        LocalDateTime fechaCreacionRespuesta,
        String autorRespuestaLogin
) {
    public DatosRespuestaRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensajeRespuesta(), respuesta.getTopico().getTitulo(),
                respuesta.getFechaCreacionRespuesta(),respuesta.getAutorRespuesta().getLogin());
    }
}
