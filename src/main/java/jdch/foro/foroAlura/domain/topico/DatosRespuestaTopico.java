package jdch.foro.foroAlura.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String tituloTopico,
        String mensajeTopico,
        LocalDateTime fechaDeCreacionTopico,
        LocalDateTime fechaUltimaEdicionTopico,
        Estado statusTopico,
        String loginAutorTopico,
        String nombreCursoTopico,
        String categoriaCurso
) {
    public DatosRespuestaTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacionTopico(),
                topico.getFechaUltimaEdicionTopico(),topico.getStatusTopico(),topico.getIdAutor().getLogin(),
                topico.getIdCurso().getNombreCurso(),topico.getIdCurso().getCategoriaCurso().toString());
    }
}
