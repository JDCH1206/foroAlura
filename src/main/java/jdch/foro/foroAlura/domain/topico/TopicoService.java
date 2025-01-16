package jdch.foro.foroAlura.domain.topico;

import jakarta.validation.Valid;
import jdch.foro.foroAlura.ValidacionException;
import jdch.foro.foroAlura.domain.curso.Curso;
import jdch.foro.foroAlura.domain.curso.CursoRepository;
import jdch.foro.foroAlura.domain.topico.validaciones.ValidadorTopicoYMensajeRepetido;
import jdch.foro.foroAlura.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    ValidadorTopicoYMensajeRepetido validadorTopicoYMensajeRepetido;
    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;
    public DatosRespuestaTopico crearTopico (DatosCrearTopico datos){
        if (!cursoRepository.existsById(datos.idCursoTopico())) {
            throw new RuntimeException("No existe un curso con el id indicado");
        }
        if (!usuarioRepository.existsById(datos.idAutorTopico())) {
            throw new RuntimeException("No existe un autor con el id indicado");
        }
        validadorTopicoYMensajeRepetido.validar(datos);
        var usuario = usuarioRepository.findById(datos.idAutorTopico()).get();
        var curso = cursoRepository.findById(datos.idCursoTopico()).get();
        var topico = new Topico(datos,usuario,curso);
        topicoRepository.save(topico);
        return new DatosRespuestaTopico(topico);
    }

    public DatosRespuestaTopico editarTopico(@Valid DatosEditarTopico datos, Long id) {

        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id indicado");
        }
        if (!cursoRepository.existsById(datos.idCurso())) {
            throw new ValidacionException("No existe un curso con el id indicado");
        }
        var topicoEditar = topicoRepository.getReferenceById(id);
        Curso curso = cursoRepository.getReferenceById(datos.idCurso());
        topicoEditar.setIdCurso(curso);
        topicoEditar.setTitulo(datos.titulo());
        topicoEditar.setMensaje(datos.mensaje());
        var fechaEdicion = LocalDateTime.now();
        topicoEditar.setFechaUltimaEdicionTopico(fechaEdicion);
        return new DatosRespuestaTopico(topicoEditar);
    }
    public DatosRespuestaTopico mostrarTopico(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id indicado");
        }
        var datosTopico = topicoRepository.getReferenceById(id);
        return new DatosRespuestaTopico(datosTopico);
    }
    public Page<DatosRespuestaTopico> mostrarListadoTopicos (Pageable paginacion){
        return topicoRepository.listadoTopicos(paginacion);
    }
    public void eliminarTopico(Long id) {
        if (!topicoRepository.existsById(id) ) {
            throw  new ValidacionException("El tópico no existe");
        }
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
