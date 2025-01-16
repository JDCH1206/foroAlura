package jdch.foro.foroAlura.domain.respuesta;

import jdch.foro.foroAlura.domain.topico.TopicoRepository;
import jdch.foro.foroAlura.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    RespuestaRepository respuestaRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public DatosRespuestaRespuesta crearRespuesta (DatosCrearRespuesta datos){
        if (!topicoRepository.existsById(datos.topicoRespuestaId())) {
            throw new RuntimeException("No existe un Tópico con el id indicado");
        }
        if (!usuarioRepository.existsById(datos.autorRespuestaId())) {
            throw new RuntimeException("No existe un autor con el id indicado");
        }
        var topico = topicoRepository.findById(datos.topicoRespuestaId()).get();
        var autor = usuarioRepository.findById(datos.autorRespuestaId()).get();
        var respuesta = new Respuesta(datos,topico,autor);
        respuestaRepository.save(respuesta);
        return new DatosRespuestaRespuesta(respuesta);
    }
}
