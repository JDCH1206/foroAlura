package jdch.foro.foroAlura.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListadoRespuestas(
        Long id,
        String mensajeRespuesta,
        String topicoRespuestaTitulo,
        LocalDateTime fechaCreacionRespuesta,
        String autorRespuestaLogin,
        LocalDateTime fechaUltimaEdicionRespuesta,
        Boolean solucion
) {
    public DatosListadoRespuestas(Respuesta respuesta){
        this(respuesta.getId(),respuesta.getMensajeRespuesta(),
                respuesta.getTopico().getTitulo(),respuesta.getFechaCreacionRespuesta(),
                respuesta.getAutorRespuesta().getLogin(), respuesta.getFechaUltimaEdicion(),respuesta.getSolucion());
    }

}
